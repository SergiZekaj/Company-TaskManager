package service;

import java.util.List;

import model.*;
import repository.TaskRepository;

public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(){
        this.taskRepository = new TaskRepository();
    }

    public Task getTaskById(String id){
        return taskRepository.getTaskById(id);
    }

    public Task addTask(String title, String description, User assignedTo, Project project){
        return taskRepository.addTask(title, description, assignedTo, project);
    }

    public List<Task> getAllTasks(){
        return taskRepository.getAllTasks();
    }

    public Task deleteTask(String id){
        return taskRepository.deleteTask(id);
    }

    public Task updateTask(String id, String title, String description, TaskStatus status, User assignedTo, Project project){
        return taskRepository.updateTask(id, title, description, status, assignedTo, project);
    }
}
