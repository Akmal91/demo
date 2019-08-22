package com.vibenar.dao;

import com.vibenar.entity.User;
import com.vibenar.mapping.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserDaoImpl implements UserDao{
    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

     public List<User> findAll() {
         String sql = "SELECT * FROM public.users";
         return jdbcTemplate.query(sql, new UserMapper());
    }

    public void save(User user) {
        String sql = "insert into public.users (name, login, password, email) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getLogin(), user.getPassword(), user.getEmail());
    }

    public void delete(int id) {
        String sql = "delete from public.users where id=?";
        jdbcTemplate.update(sql, id);
    }

    public void update(User user) {
        String sql = "update public.users set name=?, email=? where id=?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getId());
    }

    public List<User> getUsers(String log, String pass) {
        String sql = "SELECT * FROM public.users where login = ? and password = ? order by id";
        return jdbcTemplate.query(sql, new Object[]{log, getMd5Digest(pass)},  new UserMapper());
    }

    public List<User> getUser(Integer id) {
        String sql = "SELECT * FROM public.users where id = ?";
        return jdbcTemplate.query(sql, new Object[]{id},  new UserMapper());
    }

    private String getMd5Digest(String str) {
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(str.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String s = number.toString(16);
            while (s.length() < 32)
                s = "0" + s;
            return s;
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
    }
}
