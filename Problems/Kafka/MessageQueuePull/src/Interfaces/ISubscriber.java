package Interfaces;

import java.util.List;

public interface ISubscriber {
    public List<IPartition> getListOfSubscribedPartitions();
    public void consumeMessage(IPartition partition);
    public void addSubscriberPartition(IPartition partition);
}
