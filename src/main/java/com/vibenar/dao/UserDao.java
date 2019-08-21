package com.vibenar.dao;

import com.vibenar.entity.User;
import java.util.List;

public interface UserDao {

    List<User> findAll();
    void save(User user);
    void delete(int id);
    void update (User user);

    List<User> getUsers(String log, String pass);
    List<User> getUser(Integer id);
}
