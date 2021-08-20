package com.ssm.service.impl;

import com.ssm.dao.AccountDao;
import com.ssm.po.Account;
import com.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao2;

    public List<Account> findAll() {
        System.out.println("业务层：查询所有账户...");
        return accountDao2.findAll();
    }

    public void saveAccount(Account account) {
        System.out.println("业务层：保存帐户...");
//        accountDao.saveAccount(account);
    }
}
