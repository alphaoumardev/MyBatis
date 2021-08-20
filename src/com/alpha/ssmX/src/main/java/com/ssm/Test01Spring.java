package com.ssm;

import com.ssm.dao.AccountDao;
import com.ssm.po.Account;
import com.ssm.service.AccountService;
import com.ssm.service.impl.AccountServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring.xml"})
public class Test01Spring {

    @Autowired
    private AccountServiceImpl accountService;

    @Test
    public void run1(){

        List list=accountService.findAll();
        System.out.println(list);
    }

    @Test
    public void testFindAll() throws Exception{
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session= factory.openSession();
        AccountDao aDao = session.getMapper(AccountDao.class);
        List<Account> list = aDao.findAll();
        System.out.println(list);
        session.close();
        in.close();
    }
}
