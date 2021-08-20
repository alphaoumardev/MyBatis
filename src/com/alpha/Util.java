/*
  Created by:oumar
  Project:MyBatis
  Name:util
  Date: 7/17/2021
  Time: 10:36 AM
*/
package com.alpha;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Util
{
    private static SqlSessionFactory factory;
    private static final ThreadLocal<SqlSession> local=new ThreadLocal<>();
    static
    {
        try
        {
            factory = new SqlSessionFactoryBuilder()
                    .build(Util.class.getClassLoader().getResourceAsStream("batis-config.xml"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static SqlSession getSession()
    {
        SqlSession session=local.get();
        if (session==null)
        {
            session=factory.openSession();
            local.set(session);
        }
        return session;
    }
    public static void close()
    {
        SqlSession session=local.get();
        if (session!=null)
        {
            session.close();
            local.remove();
        }
    }

}
