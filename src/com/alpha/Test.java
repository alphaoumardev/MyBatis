/*
  Created by:oumar
  Project:MyBatis
  Name:Test
  Date: 7/17/2021
  Time: 10:53 AM
*/
package com.alpha;

import com.alpha.dao.UserDao;
import com.alpha.entity.User;
import org.apache.ibatis.session.SqlSession;

public class Test
{
    public static void main(String[] args)
    {
        SqlSession session=null;
        try {
           session = Util.getSession();
            User user = new User();
            user.setId(25);
            user.setFullName("Oumar");
            user.setAddress("Huaian");
            user.setCountry("China");
            user.setEmail("oumardialo98@gmail.com");
            user.setMobile("132332343785");

            UserDao userDao = session.getMapper(UserDao.class);
//            userDao.insertUser(user);
            userDao.selectUserById("diallo","china");
            userDao.selectByParam("oumar","china");
//            userDao.selectUser();//all entities
            userDao.selectByWhere("alpha","china");
            getCommit(session);

        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        finally
        {
            com.alpha.Util.close();
        }
    }

    private static void getCommit(SqlSession session) {
        session.commit();
    }
}
