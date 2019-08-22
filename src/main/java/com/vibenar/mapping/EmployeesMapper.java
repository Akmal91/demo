package com.vibenar.mapping;

import com.vibenar.entity.Employees;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeesMapper implements RowMapper<Employees> {
    public Employees mapRow(ResultSet resultSet, int i) throws SQLException {
        Employees emp = new Employees ();
        emp.setId(resultSet.getInt("id"));
        emp.setName(resultSet.getString("name"));
        emp.setLast_name(resultSet.getString("last_name"));
        emp.setMiddle_name(resultSet.getString("middle_name"));
        emp.setEmail(resultSet.getString("email"));
        emp.setNationality(resultSet.getString("nationality"));
        emp.setDate_of_birth(resultSet.getDate("date_of_birth"));
        emp.setStudy(resultSet.getString("study"));
        emp.setDate_of_finish(resultSet.getDate("date_of_finish"));
        emp.setPhone(resultSet.getString("phone"));
        emp.setEducation(resultSet.getString("education"));
        return emp;
    }
}
