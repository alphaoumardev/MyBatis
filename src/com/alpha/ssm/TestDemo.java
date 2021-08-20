package org.ssm;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.ssm.beans.User;
import org.ssm.dao.UserDao;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestDemo
{
    @Test
    public void testMyBatis() throws IOException
    {
        InputStream inputStream= Resources.getResourceAsStream("sqlMap.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserDao userDao =sqlSession.getMapper(UserDao.class);
        List<User> list=userDao.findAll();
        for (User user : list)
        {
            System.out.println(user);
        }
        sqlSession.close();
        inputStream.close();

    }
}
