package org.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ssm.beans.User;
import org.ssm.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @RequestMapping("/find")
    public String findAllUser(Model model)
    {
        List<User> list=userService.findAll();
        for(User user : list)
        {
            System.out.println(user);
        }
        model.addAttribute("list",list);
        return "userList";
    }
    @RequestMapping("saveInfo")
    public String saveUser(User user, Model model)
    {
        userService.saveInfo(user);
        return "succes";
    }
}
