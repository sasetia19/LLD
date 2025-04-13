package Implementations;

import Interfaces.IMessageQueue;
import Interfaces.ISubscriber;
import Interfaces.ITopic;
import Models.QueueMessage;

public class Subscriber implements ISubscriber {
    public String name;

    public Subscriber(String name){
        this.name = name;
    }

    @Override
    public void consumeMessage(QueueMessage message,Integer topicId) {
        System.out.println("Following message has been consumed by "+ name+ " from "+topicId+" topic!");
        System.out.println(message.message);
    }
}
