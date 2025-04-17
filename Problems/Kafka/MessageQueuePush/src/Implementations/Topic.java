package Implementations;

import Interfaces.IPartition;
import Interfaces.ISubscriber;
import Interfaces.ITopic;
import Models.QueueMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

public class Topic implements ITopic {

    private Integer topicId;
    private List<IPartition> listOfPartitions;
    private List<ISubscriber> listOfSubscribers;

    public Topic(Integer topicId){
        listOfPartitions = new ArrayList<IPartition>();
        listOfSubscribers = new ArrayList<ISubscriber>();
        this.topicId = topicId;
    }

    public Integer getTopicId(){
        return topicId;
    }

    @Override
    public void addNewPartition() {
        IPartition partition = new Partition(this);
        listOfPartitions.add(partition);
    }

    @Override
    public void removePartition() {
        listOfPartitions.remove(listOfPartitions.size()-1);
    }

    @Override
    public void subscriberToTopic(ISubscriber subscriber) {
        listOfSubscribers.add(subscriber);
    }

    @Override
    public void unsubscriberFromTopic(ISubscriber subscriber) {
        listOfSubscribers.remove(subscriber);
    }

    @Override
    public void addMessageToTopic(QueueMessage message) {
        RandomGenerator rand = RandomGenerator.getDefault();
        Integer idxOfPartition = rand.nextInt(0, listOfPartitions.size());
        listOfPartitions.get(idxOfPartition).addMessageToPartition(message);
//        consumeFromTopic();
    }

//    @Override
//    public void consumeFromTopic() {
//        for(IPartition partition: listOfPartitions){
//            if(partition.hasMessage()){
//                QueueMessage message = partition.consumeMessageFromPartition();
//                notifyAllSubscribers(message);
//            }
//        }
//    }
    @Override
    public void notifyAllSubscribers(QueueMessage message){
        for(ISubscriber subscriber: listOfSubscribers){
            subscriber.consumeMessage(message,topicId);
        }
    }
}
