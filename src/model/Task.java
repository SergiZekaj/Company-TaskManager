package model;

public class Task {
    private String id;
    private String title;
    private  String description;
    private TaskStatus status;
    private User assignedTo;
    private Project project;

    public Task(String id, String title, String description, TaskStatus status, User assignedTo, Project project){
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.assignedTo = assignedTo;
        this.project = project;
    }

    public String getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public TaskStatus getStatus(){
        return status;
    }

    public User getAssignedTo(){
        return assignedTo;
    }

    public Project getProject(){
        return project;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setStatus(TaskStatus status){
        this.status = status;
    }

    public void setAssignedTo(User assignedTo){
        this.assignedTo = assignedTo;
    }

    public void setProject(Project project){
        this.project = project;
    }
}

