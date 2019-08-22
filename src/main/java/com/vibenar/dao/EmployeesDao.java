package com.vibenar.dao;

import com.vibenar.entity.Employees;

import java.util.List;

public interface EmployeesDao {
    void save(Employees emp);
    void delete(int id);
    void update (Employees emp);

    List<Employees> findAll();
    List<Employees> getEmployee(Integer id);
}
