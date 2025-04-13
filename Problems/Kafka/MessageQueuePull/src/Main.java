import Implementations.MessageQueue;
import Implementations.Subscriber;
import Interfaces.IMessageQueue;
import Interfaces.ISubscriber;
import Model.QueueMessage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        IMessageQueue messageQueue = new MessageQueue();
        messageQueue.addTopic();
        messageQueue.addTopic();
        messageQueue.addTopic();


        ISubscriber subscriber1 = new Subscriber("FirstSubscriber");
        ISubscriber subscriber2 = new Subscriber("SecondSubscriber");

        messageQueue.subscribeToTopic(1,subscriber1);
        messageQueue.subscribeToTopic(2,subscriber1);
        messageQueue.subscribeToTopic(2,subscriber2);
        messageQueue.subscribeToTopic(3,subscriber2);

        QueueMessage message1 = new QueueMessage("FirstMessage",10);
        QueueMessage message2 = new QueueMessage("SecondMessage",11);
        QueueMessage message3 = new QueueMessage("ThirdMessage",12);

        messageQueue.publishMessage(message1,1);
        Thread.sleep(2000);
        messageQueue.publishMessage(message1,2);
        messageQueue.publishMessage(message2,1);
        messageQueue.publishMessage(message3,2);
        messageQueue.publishMessage(message3,3);

        /*
        IQueue interface -> publishMessage(), subscribeToTopic(topicId,Subscriber),addTopic(),removeTopic(),
        Queue class -> List<ITopics>

        ITopic interface -> addMessageToTopic(), addPartition(),removePartition(),consumeFromTopic()
        Topic -> List<IPartitions>, List<ISubscribers>

        IPartition interface -> addMessageToPartition(), hasData(), consumeFromPartition()
        Partition -> queue<QueueMessage>

        ISubscriber -> receiveMessage()
        Subscriber -> name,id,

        SubscriberRunnable -> check and consume message at a constant rate.


        QueueMessage model class
         */
        /*
        extra points to be notted
        declare methods synchronised
        Use only thread safe data structures, otherwise it will give concurrentModificationException
        like instead of ArrayList use CopyOnWriteArrayList
        instead of HashMap, use ConcurrentHashMap
         */

    }
}