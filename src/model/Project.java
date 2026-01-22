package model;

public class Project {
    private String id;
    private String name;
    private User owner;

    public Project(String id, String name, User owner){
        this.id = id;
        this.name = name;
        this.owner = owner;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public User getOwner(){
        return owner;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setOwner(User owner){
        this.owner = owner;
    }
}
