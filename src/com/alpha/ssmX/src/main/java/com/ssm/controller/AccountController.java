package com.ssm.controller;

import com.ssm.po.Account;
import com.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("accountController")
@RequestMapping("/account")
public class AccountController {



//    @RequestMapping("/findAll")
//    public String findAllAccount() {
//        System.out.println("执行了查询账户");
//        return "success";
//    }


    @Autowired
    private AccountService accountService;
    /** * 查询所有账户
     * @return */
    @RequestMapping("/findAll")
    public ModelAndView findAllAccount() {
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
        ModelAndView mv = new ModelAndView();
        mv.addObject("accounts", accounts);
        mv.setViewName("list");
        return mv;
    }
}
