package com.vibenar.dao;

import com.vibenar.entity.Employees;
import com.vibenar.mapping.EmployeesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EmployeesDaoImpl implements EmployeesDao{
    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeesDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Employees emp) {
        String sql = "insert into public.employees (name, last_name, middle_name, email, nationality, date_of_birth, study, " +
                "date_of_finish, phone, education) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, emp.getName(), emp.getLast_name(), emp.getMiddle_name(), emp.getEmail(), emp.getNationality(),
                emp.getDate_of_birth(), emp.getStudy(), emp.getDate_of_finish(), emp.getPhone(), emp.getEducation());
    }

    public void delete(int id) {
        String sql = "delete from public.employees where id=?";
        jdbcTemplate.update(sql, id);
    }

    public void update(Employees emp) {
        String sql = "update public.employees set name=?, last_name=?, middle_name=?, email=?, nationality=?, date_of_birth=?, " +
                "study=?, date_of_finish=?, phone=?, education=? where id=?";
        jdbcTemplate.update(sql, emp.getName(), emp.getLast_name(), emp.getMiddle_name(), emp.getEmail(), emp.getNationality(),
                emp.getDate_of_birth(), emp.getStudy(), emp.getDate_of_finish(), emp.getPhone(), emp.getEducation());
    }

    public List<Employees> findAll() {
        String sql = "SELECT * FROM public.employees";
        return jdbcTemplate.query(sql, new EmployeesMapper());
    }

    public List<Employees> getEmployee(Integer id) {
        String sql = "SELECT * FROM public.employees where id = ?";
        return jdbcTemplate.query(sql, new Object[]{id},  new EmployeesMapper());
    }
}
