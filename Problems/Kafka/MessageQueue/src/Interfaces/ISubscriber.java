package Interfaces;

import Models.QueueMessage;

public interface ISubscriber {
    public void consumeMessage(QueueMessage message,Integer topicId);
}
