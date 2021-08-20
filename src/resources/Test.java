/*
  Created by:oumar
  Project:MyBatis
  Name:Test
  Date: 7/16/2021
  Time: 4:52 PM
*/
package resources;

import com.alpha.dao.UserDao;
import com.alpha.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.sql.Connection;

public class Test
{
    public static void main(String[] args)
    {
         SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
         SqlSessionFactory factory=builder.build(Test.class.getClassLoader().getResourceAsStream("batis-config.xml"));
         
         SqlSession session= factory.openSession();
//        InputStream inputStream=session.getInputStream();

         Connection conn= session.getConnection();

        System.out.println("conn = " + conn);
        User user=new User();
        user.setId(21);
        user.setFullName("Alpha");
        user.setAddress("Huaian");
        user.setCountry("China");
        user.setEmail("oumardialo98@gmail.com");
        user.setMobile("1323323785");

//        session.insert("com.alpha.mapper.UserMapper.resultUser",user);
        UserDao userDao=session.getMapper(UserDao.class);
        userDao.insertUser(user);
        session.commit();
//        conn.close();
    }

}
