package com.vibenar.controller;

import com.vibenar.entity.User;
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

    @GetMapping("/")
    public String getIndex(){

        return "index";
    }

    @GetMapping("/hello")
    public String getHello(){
        return "hello";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.findAll());
        return "usersList";
    }

    @PostMapping("/login")
    public String getLogin(@RequestParam(value = "log") String log, @RequestParam(value = "pass") String pass, Model model){
        List<User> users = userService.getUsers(log, pass);
        if(users==null || users.isEmpty()){
            return "error";
        }
        model.addAttribute("users", userService.findAll());
        return "usersList";
    }

    @GetMapping("/cv")
    public String getCV(Model model, @RequestParam(value = "id") Integer id){
        List<User> list = userService.getUser(id);
        model.addAttribute("user", list.get(0));
        return "userCV";
    }

    @GetMapping("/addUser")
    public String createUserPage(){
        return "createUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/cv?id="+user.getId();
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getUser(id).get(0));
        return "editUser";
    }

}
