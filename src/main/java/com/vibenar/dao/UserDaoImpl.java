package com.vibenar.dao;

import com.itextpdf.text.DocumentException;
import com.vibenar.entity.User;
import com.vibenar.mapping.UserMapper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.util.List;

public class UserDaoImpl implements UserDao{
    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

     public List<User> findAll() {
         String sql = "SELECT * FROM public.user";
         return jdbcTemplate.query(sql, new UserMapper());
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
        return jdbcTemplate.query(sql, new Object[]{log, pass},  new UserMapper());
    }

    public List<User> getUser(Integer id) {
        String sql = "SELECT * FROM public.user where id = ?";
        return jdbcTemplate.query(sql, new Object[]{id},  new UserMapper());
    }

    public void printp(User user){

    }

    public void convertToPdf(int id) throws IOException {

        String sql = "SELECT * FROM public.user WHERE id=?";
        User user= jdbcTemplate.queryForObject(sql, new UserMapper(), id);
        PDDocument document = new PDDocument();

        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.setFont(PDType1Font.COURIER_BOLD, 20);

        contentStream.beginText();

        StringBuilder builder=new StringBuilder();
        builder.append(user.getName());
        builder.append(user.getEmail());
        builder.append(user.getAge());


        contentStream.showText(builder.toString());



        contentStream.endText();
        contentStream.close();

        document.save("e://"+user.getName()+".pdf");
        document.close();
    }
}
