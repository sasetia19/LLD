import Implementations.MessageQueue;
import Implementations.Subscriber;
import Interfaces.IMessageQueue;
import Interfaces.ISubscriber;
import Models.QueueMessage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
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

        messageQueue.addMessageToQueue(1,message1);
        messageQueue.addMessageToQueue(2,message1);
        messageQueue.addMessageToQueue(1,message2);
        messageQueue.addMessageToQueue(2,message3);
        messageQueue.addMessageToQueue(3,message3);


        /*
        Message Queue
        Publishers -> Queue (topic (partition)) -> subscribers/consumers

        MessageQueueService ->

        IMessageQueue -> addTopic(),removeTopic(), addMessageToQueue()
        FIFOQueue -> List<ITopic>,

        ITopic -> addPartition(),removePartition(), subscriberToTopic(),unsubscriberToTopic(),
                    addMessageToTopic(), consumeFromTopic(),
        Topic -> List<IPartitions>

        IPartition -> addMessageToPartition(), consumeFromPartition(),
        Partition -> List<String> messages

        Publisher ->

        Consumers -> receiveMessage(),
         */
    }
}