package Interfaces;

import Implementations.Subscriber;
import Model.QueueMessage;

public interface ITopic {
    public void addMessageToTopic(QueueMessage message);
    public void addPartition();
    public void removePartition();
    public Integer getTopicId();
    public void addSubscriber(ISubscriber subscriber);
    public void removeSubscriber(ISubscriber subscriber);

}
