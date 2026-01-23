package repository;

import model.Project;
import model.User;

import java.util.*;

public class ProjectRepository {
    private Map<String, Project> projectMap = new HashMap<>();

    public Project getProjectById(String id){
        return projectMap.get(id);
    }

    public Project addProject(String name, User owner){
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        Project createdProject = new Project(uuidAsString, name, owner);
        projectMap.put(uuidAsString, createdProject);
        return createdProject;
    }

    public List<Project> getAllProjects(){
        return new ArrayList<>(projectMap.values());
    }

    public Project deleteProjectById(String id){
        Project deletedProject = projectMap.get(id);
        projectMap.remove(id);
        return deletedProject;
    }

    public Project updateProject(String id, String name, User owner){
        Project project = projectMap.get(id);
        project.setName(name);
        projectMap.put(id, project);
        return project;
    }

}
