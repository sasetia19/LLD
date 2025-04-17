package Interfaces;

import Models.QueueMessage;

public interface IMessageQueue {
    public void addTopic();
    public void removeTopic();
    public void addMessageToQueue(Integer topicId, QueueMessage message);
    public void subscribeToTopic(Integer topicId,ISubscriber subscriber);
}
