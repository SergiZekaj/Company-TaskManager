package repository;

import model.Project;
import model.Task;
import model.TaskStatus;
import model.User;

import java.util.*;

public class TaskRepository {
    private Map<String, Task> taskMap = new HashMap<>();

    public Task getTaskById(String id){
        return taskMap.get(id);
    }

    public Task addTask(String title, String description, User assignedTo, Project project){
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        Task createdTask = new Task(uuidAsString, title, description, TaskStatus.IN_PROGRESS, assignedTo, project);
        taskMap.put(uuidAsString, createdTask);
        return createdTask;
    }

    public List<Task> getAllTasks(){
        return new ArrayList<>(taskMap.values());
    }

    public Task deleteTask(String id){
        Task deletedTask = taskMap.get(id);
        taskMap.remove(id);
        return deletedTask;
    }

    public Task updateTask(String id, String title, String description, TaskStatus status, User assignedTo, Project project){
        Task updatedTask = taskMap.get(id);
        updatedTask.setTitle(title);
        updatedTask.setDescription(description);
        updatedTask.setStatus(status);
        updatedTask.setAssignedTo(assignedTo);
        updatedTask.setProject(project);
        taskMap.put(id, updatedTask);
        return updatedTask;
    }
}

