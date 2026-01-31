package service;

import java.util.List;

import model.*;
import repository.ProjectRepository;

public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(){
        this.projectRepository = new ProjectRepository();
    }

    public Project getProjectById(String id){
        return projectRepository.getProjectById(id);
    }

    public Project addProject(String name, User owner){
        return projectRepository.addProject(name, owner);
    }

    public List<Project> getAllProjects(){
        return projectRepository.getAllProjects();
    }

    public Project deleteProjectById(String id){
        return projectRepository.deleteProjectById(id);
    }

    public Project updateProject(String id, String name, User owner){
        return projectRepository.updateProject(id, name, owner);
    }
}
