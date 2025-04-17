package Interfaces;

import Models.QueueMessage;

public interface ITopic {

    public void addNewPartition();
    public void removePartition();
    public void subscriberToTopic(ISubscriber subscriber);
    public void unsubscriberFromTopic(ISubscriber subscriber);
    public void addMessageToTopic(QueueMessage message);
    public void consumeFromTopic();
    public Integer getTopicId();
    public void notifyAll(QueueMessage message);
}
