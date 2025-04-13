package Implementations;

import Interfaces.IPartition;
import Interfaces.ITopic;
import Models.QueueMessage;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Partition implements IPartition {

    private BlockingQueue<QueueMessage> listOfMessages;
    private ITopic topic;
    private Thread partitionThread;

    public Partition(ITopic topic){
        listOfMessages = new LinkedBlockingDeque<QueueMessage>();
        this.topic = topic;
        partitionThread = new Thread(new PartitionRunnable(this));
        partitionThread.start();
    }

    @Override
    public synchronized void addMessageToPartition(QueueMessage message) {

        listOfMessages.add(message);
        notify();
    }

    @Override
    public QueueMessage consumeMessageFromPartition() {
        return listOfMessages.poll();
    }

    @Override
    public synchronized Boolean hasMessage() {
        if(listOfMessages.size() > 0)return true;
        try {
            System.out.println(partitionThread.getName()+" is in waiting");
            wait();
        } catch (InterruptedException e) {
            System.out.println("Thread waiting as queue is empty");
            throw new RuntimeException(e);
        }
        return false;
    }

    public void notifyAllSubscribers(QueueMessage message){
        topic.notifyAllSubscribers(message);
    }
}
