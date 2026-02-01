package service;

import java.util.List;

import errors.*;
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
    
    public User addUser(String name, String email, String password){
        ErrorResponse errorResponse = new ErrorResponse();

        Validations.validateName(name, errorResponse);
        Validations.validateEmail(email, errorResponse);
        Validations.validatePassword(password, errorResponse);
        
        if (userRepository.emailExists(email)) {
            errorResponse.addFieldError("email", "Email already exists");
        }

        if(errorResponse.hasErrors()){
            throw new IllegalArgumentException(errorResponse.getFieldErrors().toString());
        }
        return userRepository.addUser(name, email, password);
    }

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public User deleteUserById(String id){
        return userRepository.deleteUserById(id);
    }

    public User updateUser(String id,String name, String email, String password){
        ErrorResponse errorResponse = new ErrorResponse();

        Validations.validateName(name, errorResponse);
        Validations.validateEmail(email, errorResponse);
        Validations.validatePassword(password, errorResponse);
        
        User currentUser = userRepository.getUserById(id);
        if(currentUser != null && !currentUser.getEmail().equalsIgnoreCase(email)){
            if(userRepository.emailExists(email)){
                errorResponse.addFieldError("email", "Email already exists");
            }
        }
        
        if(errorResponse.hasErrors()){
            throw new IllegalArgumentException(errorResponse.getFieldErrors().toString());
        }
        return userRepository.updateUser(id,name, email, password);
    }
}