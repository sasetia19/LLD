import Implementations.RecurringTask;
import Implementations.ScheduledTask;
import Implementations.TaskScheduler;
import Interfaces.ITaskScheduler;

import java.time.Instant;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ITaskScheduler taskScheduler = TaskScheduler.getInstance(2);

        taskScheduler.scheduleTask(new ScheduledTask("FirstTask", Instant.now().plusSeconds(2),1));
        taskScheduler.scheduleTask(new RecurringTask("SecondTask",Instant.now().plusSeconds(2),2,2));
        taskScheduler.scheduleTask(new ScheduledTask("ThirdTask",Instant.now().plusSeconds(2),3));
        taskScheduler.scheduleTask(new RecurringTask("FourthTask",Instant.now().plusSeconds(4),2,2));

        /*
        Task Scheduler

        ITask -> execute() (assume each task takes 2 sec to complete)
        ScheduledTask -> name/id, scheduledTime, priority
        RecurringTask -> name/id, scheduledTime, recurringInterval, priority

        ITaskStore -> hasTask(), getNextTask(), addTask(), removeTask()
        TaskStore -> PriorityQueue<ITask>,

        ITaskScheduler -> scheduleTask(ITask)
        TaskScheduler -> ITaskStore, numberOfThreads, List<Threads>

        TaskSchedulerRunnable --> run()

        Main

        ITaskScheduler taskScheduler = TaskScheduler.getTaskSchedulerInstance(2);

        taskScheduler.scheduleTask(new ScheduledTask("FirstTask",currTime+2,1);
        taskScheduler.scheduleTask(new RecurringScheduledTask("FirstTask",currTime+2,2,2);
        taskScheduler.scheduleTask(new ScheduledTask("FirstTask",currTime+2,3)
        taskScheduler.scheduleTask(new RecurringScheduledTask("FirstTask",currTime+4,2);
        


         */
    }
}