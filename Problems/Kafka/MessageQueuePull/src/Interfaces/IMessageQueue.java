package Interfaces;

import Implementations.Subscriber;
import Model.QueueMessage;

public interface IMessageQueue {
    public void publishMessage(QueueMessage message,Integer topicId);
    public void subscribeToTopic(Integer topicId, ISubscriber Subscriber);
    public void addTopic();
    public void removeTopic();
}
