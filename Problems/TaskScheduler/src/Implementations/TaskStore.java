package Implementations;

import Interfaces.ITask;
import Interfaces.ITaskStore;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class TaskStore implements ITaskStore {

    PriorityBlockingQueue<ITask> listOfTasks;
    Comparator<ITask> comparator;
    private static ITaskStore store;

    private TaskStore(){
        comparator = new Comparator<ITask>() {
            @Override
            public int compare(ITask t1, ITask t2) {
                int x = t1.getExecutionTime().compareTo(t2.getExecutionTime());
                if(x==0){
                    return t1.getTaskPriority().compareTo(t2.getTaskPriority());
                }
                return x;
            }
        };
        listOfTasks = new PriorityBlockingQueue<ITask>(10,comparator);
    }

    public synchronized static ITaskStore getInstance(){
        if(store == null){
            store = new TaskStore();
        }
        return store;
    }

    /*
    the above function is a bit slow as compared to below implementation.
    Alternate - use a lock object
    two options 1. apply lock on class instance like this synchronized(this) ->
    this will block any other thread trying to aquire lock on this instance to run other methods. If that is not harming then use the second option
    2. private static final Object lockObject = new Object();
    synchronized(lockObject)
    Why use a separate lockObject?
When you want to synchronize access to a block of code or resource without locking on this or
 the class itself
     */

    @Override
    public synchronized Boolean hasTask() {
        return !listOfTasks.isEmpty();
    }

    @Override
    public synchronized ITask getNextTask() {
        if(!hasTask())return null;
        return listOfTasks.poll();
    }

    @Override
    public void addTask(ITask task) {
        listOfTasks.add(task);
    }

    @Override
    public void removeTask(ITask task) {
        listOfTasks.remove(task);
    }

}
