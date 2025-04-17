package Interfaces;

public interface ITaskStore {
    public Boolean hasTask();
    public ITask getNextTask();
    public void addTask(ITask task);
    public void removeTask(ITask task);
}
