package com.vibenar.service;

import com.vibenar.dao.EmployeesDao;
import com.vibenar.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    EmployeesDao employeesDao;

    public void save(Employees emp) {
        employeesDao.save(emp);
    }

    public void delete(int id) {
        employeesDao.delete(id);
    }

    public void update(Employees emp) {
        employeesDao.update(emp);
    }

    public List<Employees> findAll() {
        return employeesDao.findAll();
    }

    public List<Employees> getEmployee(Integer id) {
        return employeesDao.getEmployee(id);
    }
}
