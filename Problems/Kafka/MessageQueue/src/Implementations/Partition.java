package Implementations;

import Interfaces.IPartition;
import Interfaces.ITopic;
import Models.QueueMessage;

import java.util.ArrayDeque;
import java.util.Queue;

public class Partition implements IPartition {

    private Queue<QueueMessage> listOfMessages;

    public Partition(){
        listOfMessages = new ArrayDeque<QueueMessage>();
    }

    @Override
    public void addMessageToPartition(QueueMessage message) {
        listOfMessages.add(message);
    }

    @Override
    public QueueMessage consumeMessageFromPartition() {
        return listOfMessages.poll();
    }

    @Override
    public Boolean hasMessage() {
        if(listOfMessages.size() > 0)return true;
        return false;
    }
}
