/*
  Created by:oumar
  Project:MyBatis
  Name:UserDao
  Date: 7/17/2021
  Time: 10:23 AM
*/
package com.alpha.dao;

import com.alpha.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao
{
    public User selectUser(User user);

    public void insertUser(User user);
    public User selectUserById(String fullName, String country);

    public User selectByParam(@Param("fullname") String fullName, @Param("country")String country);

    public User selectByif(@Param("fullname") String fullName, @Param("country") String country);

    public User selectByChoose(@Param("fullname") String fullName,@Param("country") String country);

    public User selectByWhere(@Param("fullname") String fullName,@Param("country") String Country);

    public User updateByset(@Param("fullname") String fullName,@Param("country") String Country);

    public User selectByTrim(@Param("fullname") String fullName,@Param("country") String Country);




}
