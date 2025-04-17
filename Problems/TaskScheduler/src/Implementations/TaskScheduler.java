package Implementations;

import Interfaces.ITask;
import Interfaces.ITaskScheduler;
import Interfaces.ITaskStore;

import java.util.ArrayList;
import java.util.List;

public class TaskScheduler implements ITaskScheduler {

//    ITaskStore, numberOfThreads, List<Threads>
    private ITaskStore taskStore;
    private Integer numberOfThreads;
    private List<Thread> listOfThreads;
    private static ITaskScheduler taskScheduler;

    private TaskScheduler(Integer numberOfThreads){
        taskStore = TaskStore.getInstance();
        this.numberOfThreads = numberOfThreads;
        listOfThreads = new ArrayList<>();
        initializeThreads();

    }

    private void initializeThreads(){
        for(int i=0;i<numberOfThreads;i++){
            Thread thread = new Thread(new TaskExecutorRunnable(taskStore));
            thread.start();
        }
    }

    public synchronized static ITaskScheduler getInstance(Integer numberOfThreads){
        if(taskScheduler == null){
            taskScheduler = new TaskScheduler(numberOfThreads);
        }
        return taskScheduler;
    }

    @Override
    public void scheduleTask(ITask task) {
        taskStore.addTask(task);
    }
}
