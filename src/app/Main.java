package app;

import model.User;
import model.Project;
import model.Task;
import model.TaskStatus;
import repository.ProjectRepository;
import repository.TaskRepository;
import repository.UserRepository;

public class Main {
    public static void main(String[] args){
        UserRepository userRepository = new UserRepository();
        ProjectRepository projectRepository = new ProjectRepository();
        TaskRepository taskRepository = new TaskRepository();

        User user1 = userRepository.addUser("Sergi", "sergiZ@gmail.com");

        Project project1 = projectRepository.addProject("Backend", user1);

        Task task1 = taskRepository.addTask("Services", "Create services for each class", user1, project1);
        System.out.println("Created Task: ");
        System.out.println(task1);

        Task fetchTask = taskRepository.getTaskById(task1.getId());
        System.out.println("Fetch Task by ID: ");
        System.out.println(fetchTask);

        System.out.println("All Tasks: ");
        for (Task task : taskRepository.getAllTasks()){
            System.out.println(task.getId() + ", " + task.getTitle() + ", " + task.getStatus());
        }

        taskRepository.updateTask(task1.getId(), "Setup Database", "Create schema", TaskStatus.DONE, user1, project1);
        System.out.println("Updated Task: ");
        System.out.println(taskRepository.getTaskById(task1.getId()));

        taskRepository.deleteTask(task1.getId());
        System.out.println("List after deletion: ");
        for(Task task : taskRepository.getAllTasks()){
            System.out.println(task.getId() + ", " + task.getTitle() + ", " + task.getStatus());
        }

    }
}
