package com.lxh.service.impl;

import com.lxh.dao.UserDao;
import com.lxh.pojo.User;
import com.lxh.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public User login(String username, String password) {
        return userDao.queryUsernameAndPassword(username, password);
    }

    @Override
    public List<User> queryList() {
        return userDao.queryList();
    }


}
