package Interfaces;

import Model.QueueMessage;

public interface IPartition {
    //addMessageToPartition(), hasData(), consumeFromPartition()
    public void addMessageToPartition(QueueMessage message);
    public Boolean hasData(ISubscriber subscriber);
    public QueueMessage consumeFromPartition(ISubscriber subscriber);
    public Integer getTopicId();
    public void initialiseOffset(ISubscriber subscriber);
}
