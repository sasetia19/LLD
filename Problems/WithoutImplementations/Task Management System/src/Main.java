//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /*
        ITaskManagementSystem
        synchronized createTask({task details}),synchronized assignTaskToUser(Task,User), searchByPriority(Priority), searchByDueDate(String),
        searchByUser(User), markTaskCompleted(Task)
        TaskManagementSystem
        List<ITask> listOfTasks, List<IUser>

        ITask -> markCompleted(),synchronized assignUser(User)
        Task
        String Title, String Description, String DueDate, Priority priority, Status status
        User user

        IUser
        getAllTasks(), getCompletedTasks(), getPendingTasks(),getInProgressTasks()
        User
        List<ITask>, id, name, email



        Enum Priority (Low,High, Medium)
        Enum Status ( pending, in progress, completed)


        DP
        1. singleton on TaskManagementSystem

         */
        /*
        https://github.com/ashishps1/awesome-low-level-design/tree/main/solutions/java/src/taskmanagementsystem
        this problem is more on implementation, so i guess maintaining map and focus
        on fast retrival for searching and filtering would be key judgement points.
         */
    }
}