package com.lxh.service;

import com.lxh.pojo.User;

import java.util.List;

public interface UserService {

    User login(String username, String password);

    List<User> queryList();
}
