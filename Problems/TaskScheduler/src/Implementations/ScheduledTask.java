package Implementations;

import Interfaces.ITask;

import java.time.Instant;

public class ScheduledTask implements ITask {
    public String name;
    Instant scheduledTime;
    Integer priority;

    public ScheduledTask(String name, Instant scheduledTime, Integer priority){
        this.name = name;
        this.scheduledTime = scheduledTime;
        this.priority = priority;
    }

    @Override
    public void execute() {
        System.out.println("Task "+name+" is starting executing now at "+ Instant.now());
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
}
