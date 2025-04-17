package Implementations;

import Interfaces.ITask;
import Interfaces.ITaskScheduler;
import Interfaces.ITaskStore;

import java.time.Duration;
import java.time.Instant;

public class TaskExecutorRunnable implements Runnable{
    private ITaskStore taskStore;
    private ITaskScheduler taskScheduler;

    public TaskExecutorRunnable(ITaskStore taskStore){
        this.taskStore = taskStore;
    }

    @Override
    public void run() {
        while (true){
            try{
                if(taskStore.hasTask()){
                    ITask task = taskStore.getNextTask();
                    Instant executionTime = task.getExecutionTime();
                    Instant now = Instant.now();
                    long diff = Duration.between(now, executionTime).toMillis();
                    if(diff>0)Thread.sleep(diff);
                    task.execute();
                    if(task instanceof RecurringTask){
                        taskStore.addTask(((RecurringTask) task).getNextExecutionTime());
                    }
                }
                //can apply here wait to avoid running of threads when there are no tasks, and
                //then notify them to start in the add task function. see kafka lld for this
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
