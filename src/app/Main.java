package app;

import model.User;
import model.Project;
import model.Task;
import model.TaskStatus;
import repository.UserRepository;

public class Main {
    public static void main(String[] args){
        UserRepository repository = new UserRepository();

        User user1 = repository.addUser("Sergi", "sergiZ@gmail.com");
        User user2 = repository.addUser("Someone", "someone@gmail.com");

        System.out.println("Get by ID: " + repository.getUserById(user1.getId()));

        System.out.println("All Users:");
        for (User user : repository.getAllUsers()){
            System.out.println(user.getName() + ", " + user.getEmail());
        }

        repository.updateUser(user2.getId(), "Fiona", "FionaA@gmail.com");
        System.out.println("User2:");
        System.out.println(repository.getUserById(user2.getId()));

        repository.deleteUserById(user2.getId());
        System.out.println("List after deletion:");
        for(User user : repository.getAllUsers()){
            System.out.println(user.getId() + ", " + user.getName() + ", " + user.getEmail());
        }

    }
}
