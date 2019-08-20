package com.vibenar.service;

import com.vibenar.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    void save(User user);
    void delete(int id);
    void update (User user);
    void convertToPdf(int id) throws IOException;

    List<User> findAll();
    List<User> getUsers(String log, String pass);
    List<User> getUser(Integer id);
}
