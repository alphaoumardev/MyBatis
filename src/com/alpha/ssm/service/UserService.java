package org.ssm.service;

import org.springframework.stereotype.Service;
import org.ssm.beans.User;

import java.util.List;

@Service("userService")
public interface UserService
{
   List<User> findAll();

   void saveUser();

   void saveInfo(User user);
}
