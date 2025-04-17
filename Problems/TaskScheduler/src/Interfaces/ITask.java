package Interfaces;

import java.time.Instant;

public interface ITask {
    public void execute();
    public Instant getExecutionTime();
    public Integer getTaskPriority();
}
