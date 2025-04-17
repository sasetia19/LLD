package Interfaces;

import Models.QueueMessage;

public interface IPartition {
    public void addMessageToPartition(QueueMessage message);
    public QueueMessage consumeMessageFromPartition();
    public Boolean hasMessage();

}
