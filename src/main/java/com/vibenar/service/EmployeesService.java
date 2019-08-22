package com.vibenar.service;

import com.vibenar.entity.Employees;
import java.util.List;

public interface EmployeesService {

    void save(Employees emp);
    void delete(int id);
    void update (Employees emp);

    List<Employees> findAll();
    List<Employees> getEmployee(Integer id);
}
