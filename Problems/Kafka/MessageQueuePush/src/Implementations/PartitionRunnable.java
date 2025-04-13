package Implementations;

import Interfaces.IPartition;
import Models.QueueMessage;

public class PartitionRunnable implements Runnable{
    IPartition partition;

    public PartitionRunnable(IPartition partition){
        this.partition = partition;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName()+" is in running");
            if(partition.hasMessage()){
                QueueMessage message = partition.consumeMessageFromPartition();
                partition.notifyAllSubscribers(message);
            }
        }
    }
}
