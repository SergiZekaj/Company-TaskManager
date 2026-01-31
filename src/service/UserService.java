package service;

import java.util.List;

import model.User;
import repository.UserRepository;

public class UserService {

    private UserRepository userRepository;

    public UserService(){
        this.userRepository = new UserRepository();
    }
    
    public User getUserById(String id){
        return userRepository.getUserById(id);
    }
    
    public User addUser(String name, String email){
        return userRepository.addUser(name, email);
    }

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public User deleteUserById(String id){
        return userRepository.deleteUserById(id);
    }

    public User updateUser(String id, String name, String email){
        return userRepository.updateUser(id, name, email);
    }


}