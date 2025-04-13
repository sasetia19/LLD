package Implementations;

import Interfaces.IPartition;
import Interfaces.ISubscriber;
import Interfaces.ITopic;
import Model.QueueMessage;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Subscriber implements ISubscriber {
    public String name;
    private List<IPartition> listOfSubscribedPartitions;
    private Thread subscriberThread;

    public Subscriber(String name){
        this.name = name;
        listOfSubscribedPartitions = new CopyOnWriteArrayList<IPartition>();
        subscriberThread = new Thread(new SubscriberRunnable(this));
        subscriberThread.start();
    }
    
    public synchronized void addSubscriberPartition(IPartition partition){
        listOfSubscribedPartitions.add(partition);
    }

    public synchronized List<IPartition> getListOfSubscribedPartitions(){
        return this.listOfSubscribedPartitions;
    }

    public synchronized void consumeMessage(IPartition partition){
        QueueMessage message = partition.consumeFromPartition(this);
        System.out.println("Following message has been consumed by "+name + " from topic "+ partition.getTopicId());
        System.out.println(message.data);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
