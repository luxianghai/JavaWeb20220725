package com.lxh.dao;

import com.lxh.pojo.User;

public interface UserDao extends BaseDao<User> {

    public User queryUsernameAndPassword(String username, String password);

}
