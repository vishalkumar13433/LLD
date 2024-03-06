package org.lld.service.impl;

import org.lld.models.User;
import org.lld.service.IUserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService implements IUserService {

    Map<Integer, User> userMap;

    public UserService() {
        this.userMap = new HashMap<>();
    }


    @Override
    public void addUsers(List<User> users) {
        for (User user : users) {
            if (userMap.get(user) != null) {
                throw new IllegalStateException("user already exists");
            }

            userMap.put(user.getId(), user);
        }
    }

    @Override
    public User getUserById(Integer userId) {
        return userMap.get(userId);
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(userMap.values());
    }
}
