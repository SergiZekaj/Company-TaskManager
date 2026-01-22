package repository;

import model.User;

import java.util.*;

public class UserRepository {
    private Map<String, User> userMap = new HashMap<String, User>();

    public User getUserById(String id){
        return userMap.get(id);
    }
    public User addUser(String name, String email){
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        User createdUser = new User(uuidAsString, name, email);
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
        userMap.remove(id);
        return deletedUser;
    }

    public User updateUser(String id, String name, String email){
        User user = userMap.get(id);
        user.setName(name);
        user.setEmail(email);
        userMap.put(id, user);
        return user;
    }

}
