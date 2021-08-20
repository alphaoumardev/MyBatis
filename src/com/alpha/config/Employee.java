package org.example.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Employee
{
    @GetMapping("/home")
    public String index()
    {
        return "index";
    }
}