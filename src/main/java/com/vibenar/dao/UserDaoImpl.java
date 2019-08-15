package com.vibenar.dao;

import com.vibenar.entity.User;
import com.vibenar.mapping.UserMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao{
    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

     public List<User> findAll() {
         String sql = "SELECT * FROM public.user";
         return jdbcTemplate.query(sql, new UserMapping());
    }

    public void save(User user) {
        String sql = "insert into public.user (name, email, age) values (?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge());
    }

    public void delete(int id) {
        String sql = "delete from public.user where id=?";
        jdbcTemplate.update(sql, id);
    }

    public void update(User user) {
        String sql = "update public.user set name=?, email=?, age=? where id=?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge(), user.getId());
    }

    public List<User> getUsers(String log, String pass) {
        String sql = "SELECT * FROM public.user where login = ? and password = ? order by id";
        return jdbcTemplate.query(sql, new Object[]{log, pass},  new UserMapping());
    }

    public List<User> getUser(Integer id) {
        String sql = "SELECT * FROM public.user where id = ?";
        return jdbcTemplate.query(sql, new Object[]{id},  new UserMapping());
    }

}
