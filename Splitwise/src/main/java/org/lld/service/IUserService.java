package org.lld.service;

import org.lld.models.User;

import java.util.List;

public interface IUserService {
    void addUsers(List<User> users);

    User getUserById(Integer userId);

    List<User> getUsers();
}
