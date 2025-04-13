package Implementations;

import Interfaces.IPartition;

import java.util.List;

public class SubscriberRunnable implements Runnable{

    private Subscriber subscriber;

    public SubscriberRunnable(Subscriber subscriber){
        this.subscriber = subscriber;
    }

    @Override
    public void run() {
        while(true){
            List<IPartition> listOfSubscriberPartitions = subscriber.getListOfSubscribedPartitions();
            for (IPartition partition: listOfSubscriberPartitions) {
                if (partition.hasData(subscriber)) {
                    subscriber.consumeMessage(partition);
                }
            }
        }
    }
}
