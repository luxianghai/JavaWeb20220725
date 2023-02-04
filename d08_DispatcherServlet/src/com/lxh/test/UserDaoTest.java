package com.lxh.test;

import com.lxh.dao.UserDao;
import com.lxh.dao.impl.UserDaoImpl;
import com.lxh.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    private UserDao userDao = new UserDaoImpl();

    @Test
    public void queryList() {
    }

    @Test
    public void queryByPrimaryKey() {
    }

    @Test
    public void add() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void queryUsernameAndPassword() {
        User user = userDao.queryUsernameAndPassword("张三", "123456");
        System.out.println(user);
    }
}