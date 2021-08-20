package org.ssm.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.ssm.beans.User;

import java.util.List;

public interface UserDao
{
   // select
    @Select("select * from user")
    public List<User> findAll();

    // saving user info
    @Insert("insert into user(username, address) values(#{username},#{address}")
    public void saveUser(User user);


  String  saveInfo(User user);
}
