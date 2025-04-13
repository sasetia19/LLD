package Implementations;

import Interfaces.IPartition;
import Interfaces.ISubscriber;
import Interfaces.ITopic;
import Model.QueueMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Partition implements IPartition {
    private List<QueueMessage> listOfMessages;
    private ITopic topic;
    private Map<ISubscriber,Integer> offset;

    public Partition(ITopic topic){

        listOfMessages = new CopyOnWriteArrayList<QueueMessage>();
        this.topic = topic;
        offset = new ConcurrentHashMap<ISubscriber,Integer>();
    }


    @Override
    public void addMessageToPartition(QueueMessage message) {
        listOfMessages.add(message);
    }

    @Override
    public synchronized Boolean hasData(ISubscriber subscriber) {
        if(offset.containsKey(subscriber) &&  offset.get(subscriber) < listOfMessages.size())return true;
        return false;
    }

    @Override
    public synchronized QueueMessage consumeFromPartition(ISubscriber subscriber) {
        Integer idxToConsume = offset.get(subscriber);
        offset.put(subscriber,idxToConsume+1);
        return  listOfMessages.get(idxToConsume);
    }
    public Integer getTopicId(){
        return topic.getTopicId();
    }

    @Override
    public void initialiseOffset(ISubscriber subscriber) {
        offset.put(subscriber,0);
    }
}
