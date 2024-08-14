package org.example.services;

import org.example.actors.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    Map<String, User> users;
    public UserService() {
        users = new HashMap<>();
    }

    public User onboardUser(String userName, String address) {
        return new User(userName);
    }

    private void addUser(User user) throws Exception {
        if (users.get(user.getId()) != null) {
            throw new Exception("user already exists !!");
        }
        users.put(user.getId(), user);
    }

    private User getUserById(String userId) throws Exception {
        if (users.get(userId) == null) {
            throw new Exception("user with this id does not exists !!");
        }

        return users.get(userId);
    }

}
