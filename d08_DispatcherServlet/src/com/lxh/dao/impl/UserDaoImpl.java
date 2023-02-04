package com.lxh.dao.impl;

import com.lxh.dao.UserDao;
import com.lxh.pojo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDaoImpl implements UserDao {

    List<User> list = new ArrayList<>(10);

    public UserDaoImpl() {
        list.add(new User("1001", "张三", 23, "123456"));
        list.add(new User("1002", "李四", 24, "111111"));
        list.add(new User("1003", "王五", 25, "123456"));
        list.add(new User("1004", "赵六", 26, "123456"));
        list.add(new User("1005", "李丽", 18, "111111"));
        list.add(new User("1006", "张三疯", 78, "000000"));
        list.add(new User("1007", "张无忌", 30, "111111"));
        list.add(new User("1008", "金毛狮王", 55, "1234456"));
    }

    @Override
    public List<User> queryList() {
        return list;
    }

    @Override
    public User queryByPrimaryKey(String primaryKey) {
        List<User> list = queryList().stream().filter(e -> e.getId() == primaryKey).collect(Collectors.toList());
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public void add(User user) {
        list.add(user);
    }

    @Override
    public void update(User user) {
        for (User u: list) {
            if (user.getId() == u.getId()) {
                u.setId(user.getId());
                u.setUsername(user.getUsername());
                u.setAge(user.getAge());
                u.setPassword(user.getPassword());
                break;
            }
        }
    }

    @Override
    public void delete(String primaryKey) {
        for (User u: list) {
            if (primaryKey == u.getId()) {
                list.remove(u);
                break;
            }
        }
    }

    public User queryUsernameAndPassword(String username, String password) {
        List<User> collect = queryList().stream()
                .filter(e -> (username.equals(e.getUsername()) && password.equals(e.getPassword())))
                .collect(Collectors.toList());
        return collect.size() > 0 ? collect.get(0) : null;
    }
}
