package com.ssm.dao;


import com.ssm.po.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 帐户dao接口
 */
@Repository("accountDao2")
public interface AccountDao {

    // 查询所有账户
    public List<Account> findAll();

    // 保存帐户信息
    public void saveAccount(Account account);

}
