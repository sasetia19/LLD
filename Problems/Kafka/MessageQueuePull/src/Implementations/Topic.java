package Implementations;

import Interfaces.IPartition;
import Interfaces.ISubscriber;
import Interfaces.ITopic;
import Model.QueueMessage;

import java.util.LinkedList;
import java.util.List;
import java.util.random.RandomGenerator;

public class Topic implements ITopic {
    List<IPartition> listOfPartitions;
    List<ISubscriber> listOfSubscribers;
    Integer topicId;

    public Topic(Integer topicId){
        listOfPartitions = new LinkedList<IPartition>();
        listOfSubscribers = new LinkedList<ISubscriber>();
        this.topicId = topicId;
    }

    @Override
    public void addMessageToTopic(QueueMessage message) {
        RandomGenerator rand = RandomGenerator.getDefault();
        Integer idxOfPartition = rand.nextInt(0, listOfPartitions.size());
        listOfPartitions.get(idxOfPartition).addMessageToPartition(message);
    }

    @Override
    public void addPartition() {
        IPartition newPartition = new Partition(this);
        listOfPartitions.add(newPartition);
    }

    @Override
    public void removePartition() {
        listOfPartitions.remove(listOfPartitions.size()-1);
    }

    @Override
    public Integer getTopicId() {
        return topicId;
    }
    public void addSubscriber(ISubscriber subscriber){
        listOfSubscribers.add(subscriber);
        for (IPartition partition: listOfPartitions){
            subscriber.addSubscriberPartition(partition);
            partition.initialiseOffset(subscriber);
        }
    }
    public void removeSubscriber(ISubscriber subscriber){
        listOfSubscribers.remove(subscriber);
    }
}
