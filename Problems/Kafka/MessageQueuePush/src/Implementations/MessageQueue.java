package Implementations;

import Interfaces.IMessageQueue;
import Interfaces.ISubscriber;
import Interfaces.ITopic;
import Models.QueueMessage;

import java.util.ArrayList;
import java.util.List;

public class MessageQueue implements IMessageQueue {

    List<ITopic> listOfTopics;

    public MessageQueue(){
        listOfTopics = new ArrayList<ITopic>();
    }

    @Override
    public void addTopic() {
        Integer newTopicId;
        if(listOfTopics.size() == 0)newTopicId=1;
        else newTopicId = listOfTopics.get(listOfTopics.size()-1).getTopicId() + 1;
        listOfTopics.add(new Topic(newTopicId));

        //dummy code to add 3 new partitions for every topic
        ITopic topic = listOfTopics.get(listOfTopics.size()-1);
        topic.addNewPartition();
        topic.addNewPartition();
        topic.addNewPartition();
    }

    @Override
    public void removeTopic() {
        listOfTopics.remove(listOfTopics.size()-1);
    }

    @Override
    public void addMessageToQueue(Integer topicId, QueueMessage message) {
        for(ITopic topic: listOfTopics){
            if(topic.getTopicId().equals(topicId)){
                topic.addMessageToTopic(message);
            }
        }
    }

    @Override
    public void subscribeToTopic(Integer topicId, ISubscriber subscriber) {
        for(ITopic topic: listOfTopics){
            if(topic.getTopicId().equals(topicId)){
                topic.subscriberToTopic(subscriber);
            }
        }
    }
}
