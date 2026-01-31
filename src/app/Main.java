package app;

import model.*;
import service.UserService;
import service.ProjectService;
import service.TaskService;

public class Main {
    public static void main(String[] args) {

        // Services
        UserService userService = new UserService();
        ProjectService projectService = new ProjectService();
        TaskService taskService = new TaskService();

        // ===== USERS =====
        User user1 = userService.addUser("Sergi", "sergiZ@gmail.com");

        System.out.println("All Users:");
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }

        // ===== PROJECTS =====
        Project project1 = projectService.addProject("Backend", user1);

        System.out.println("\nAll Projects:");
        for (Project project : projectService.getAllProjects()) {
            System.out.println(project);
        }

        // ===== TASKS =====
        Task task1 = taskService.addTask(
                "Services",
                "Create services for each class",
                user1,
                project1
        );

        System.out.println("\nCreated Task:");
        System.out.println(task1);

        System.out.println("\nFetch Task by ID:");
        System.out.println(taskService.getTaskById(task1.getId()));

        System.out.println("\nAll Tasks:");
        for (Task task : taskService.getAllTasks()) {
            System.out.println(task.getId() + ", " + task.getTitle() + ", " + task.getStatus());
        }

        taskService.updateTask(
                task1.getId(),
                "Setup Database",
                "Create schema",
                TaskStatus.DONE,
                user1,
                project1
        );

        System.out.println("\nUpdated Task:");
        System.out.println(taskService.getTaskById(task1.getId()));

        taskService.deleteTask(task1.getId());

        System.out.println("\nTasks after deletion:");
        for (Task task : taskService.getAllTasks()) {
            System.out.println(task);
        }
    }
}
