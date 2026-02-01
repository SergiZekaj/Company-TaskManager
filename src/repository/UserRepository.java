package repository;

import model.User;

import java.util.*;

public class UserRepository {
    private Map<String, User> userMap = new HashMap<String, User>();
    private Map<String, String> emailToIdMap = new HashMap<>();

    public boolean emailExists(String email){
        return emailToIdMap.containsKey(email.toLowerCase());
    }

    public String getUserIdByEmail(String email){
        return emailToIdMap.get(email.toLowerCase());
    }

    public User getUserById(String id){
        return userMap.get(id);
    }
    public User addUser(String name, String email, String password){
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        User createdUser = new User(uuidAsString, name, email, password);
        emailToIdMap.put(email.toLowerCase(), uuidAsString);
        userMap.put(uuidAsString, createdUser);
        return createdUser;
    }

    public List<User> getAllUsers(){
        return new ArrayList<>(userMap.values());
//userMap.values() returns Collection that's why I need to use ArrayList<>.
//  what is actually happening:
//        ArrayList<User> list = new ArrayList<>();
//
//        for (User user : userMap.values()) {
//            list.add(user);
//        }
    }

    public User deleteUserById(String id){
        User deletedUser = userMap.get(id);
        if(deletedUser != null){
            emailToIdMap.remove(deletedUser.getEmail().toLowerCase());
            userMap.remove(id);
        }
        return deletedUser;
    }

    public User updateUser(String id, String name, String email, String password){
        User user = userMap.get(id);
        if(user == null){
            throw new NoSuchElementException("User not found");
        }if(!user.getEmail().equalsIgnoreCase(email)){
            emailToIdMap.remove(user.getEmail().toLowerCase());
            emailToIdMap.put(email.toLowerCase(), id);
        }
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        return user;
    }

}
