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
        User user1 = userService.addUser("Sergi", "sergiZ@gmail.com", "Password123!");
        System.out.println("Created User: " + user1);

        // Password verification test
        System.out.println("Password verification (correct): " + user1.verifyPassword("Password123!"));
        System.out.println("Password verification (wrong): " + user1.verifyPassword("WrongPassword123!"));

        User user2 = userService.addUser("Alice", "alice@gmail.com", "Password123!");
        System.out.println("Created User: " + user2);

        // Email uniqueness check - try duplicate email
        try {
            userService.addUser("John", "sergiZ@gmail.com", "Password123!");
        } catch (IllegalArgumentException e) {
            System.out.println("Email check: Duplicate email rejected");
        }

        System.out.println("\nAll Users:");
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }

        User updatedUser = userService.updateUser(user1.getId(), "Sergi Updated", "sergiUpdated@gmail.com", "NewPassword123!");
        System.out.println("\nUpdated User: " + updatedUser);
        
        // Password update verification test
        System.out.println("New password verification: " + updatedUser.verifyPassword("NewPassword123!"));
        System.out.println("Old password (should fail): " + updatedUser.verifyPassword("Password123!"));

        // Email uniqueness check - try to update to existing email
        try {
            userService.updateUser(user1.getId(), "Sergi", "alice@gmail.com", "Password123!");
        } catch (IllegalArgumentException e) {
            System.out.println("Email check: Cannot update to existing email");
        }

        // ===== PROJECTS =====
        Project project1 = projectService.addProject("Backend", user1);
        System.out.println("\nCreated Project: " + project1);

        Project project2 = projectService.addProject("Frontend", user2);
        System.out.println("Created Project: " + project2);

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

        System.out.println("\nCreated Task: " + task1);

        Task task2 = taskService.addTask(
                "Database Setup",
                "Configure database connection",
                user2,
                project1
        );

        System.out.println("Created Task: " + task2);

        System.out.println("\nFetch Task by ID:");
        System.out.println(taskService.getTaskById(task1.getId()));

        System.out.println("\nAll Tasks:");
        for (Task task : taskService.getAllTasks()) {
            System.out.println(task.getId() + ", " + task.getTitle() + ", " + task.getStatus());
        }

        // Update task
        taskService.updateTask(
                task1.getId(),
                "Setup Database",
                "Create schema and tables",
                TaskStatus.DONE,
                user1,
                project1
        );

        System.out.println("\nUpdated Task:");
        System.out.println(taskService.getTaskById(task1.getId()));

        // Delete task
        taskService.deleteTask(task2.getId());

        System.out.println("\nTasks after deletion:");
        for (Task task : taskService.getAllTasks()) {
            System.out.println(task);
        }

        // Test user deletion
        userService.deleteUserById(user2.getId());
        System.out.println("\nUsers after deletion:");
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }
    }
}
