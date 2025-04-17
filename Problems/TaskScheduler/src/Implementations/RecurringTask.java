package Implementations;

import Interfaces.ITask;

import java.time.Instant;

public class RecurringTask implements ITask {
    public String name;
    Instant scheduledTime;
    Integer priority;
    Integer recurringInterval;

    public RecurringTask(String name, Instant scheduledTime, Integer priority, Integer recurringInterval){
        this.name = name;
        this.scheduledTime = scheduledTime;
        this.priority = priority;
        this.recurringInterval = recurringInterval;
    }



    @Override
    public void execute() {
        System.out.println("Task "+name+" is startingexecuting now at "+ Instant.now());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task "+name+" is finished now at "+ Instant.now());
    }

    @Override
    public Instant getExecutionTime() {
        return scheduledTime;
    }

    @Override
    public Integer getTaskPriority() {
        return priority;
    }
    public ITask getNextExecutionTime(){
        scheduledTime = scheduledTime.plusSeconds(recurringInterval);
        return this;
    }
}
