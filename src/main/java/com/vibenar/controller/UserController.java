package com.vibenar.controller;

import com.vibenar.entity.Employees;
import com.vibenar.entity.User;
import com.vibenar.service.EmployeesService;
import com.vibenar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    public UserService userService;

    @Autowired
    public EmployeesService employeesService;

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @PostMapping("/login")
    public String getLogin(@RequestParam(value = "log") String log, @RequestParam(value = "pass") String pass, Model model){
        List<User> users = userService.getUsers(log, pass);
        if(users==null || users.isEmpty()){
            return "error";
        }
        model.addAttribute("employees", employeesService.findAll());
        return "usersList";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        employeesService.delete(id);
        return "redirect:/employees";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", employeesService.getEmployee(id).get(0));
        return "editUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("employee") Employees emp){
        employeesService.update(emp);
        return "redirect:/cv?id="+emp.getId();
    }

    @GetMapping("/addUser")
    public String createUserPage(){
        return "createUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("employee") Employees emp){
        employeesService.save(emp);
        return "redirect:/employees";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute("user") User user, Model model){
        userService.save(user);
        model.addAttribute("employees", employeesService.findAll());
        return "usersList";
    }




    @GetMapping("/employees")
    public String getAllUsers(Model model){
        model.addAttribute("employees", employeesService.findAll());
        return "usersList";
    }

    @GetMapping("/register")
    public String getReg(){
        return "register";
    }

    @GetMapping("/cv")
    public String getCV(Model model, @RequestParam(value = "id") Integer id){
        List<Employees> list = employeesService.getEmployee(id);
        model.addAttribute("employee", list.get(0));
        return "userCV";
    }









}
