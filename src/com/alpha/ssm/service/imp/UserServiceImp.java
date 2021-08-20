package org.ssm.service.imp;

import org.ssm.beans.User;
import org.ssm.dao.UserDao;
import org.ssm.service.UserService;

import java.util.List;

public class UserServiceImp implements UserService
{
    private UserDao userDao;
    @Override //the user
    public List<User> findAll()
    {
        System.out.println("Finding all the user info");
        return userDao.findAll();
    }

    @Override
    public void saveUser()
    {
        System.out.println("Saving the user info");
    }

    @Override
    public void saveInfo(User user)
    {
        userDao.saveInfo(user);
    }
}
