package com.lxh.dao;

import java.util.List;

public interface BaseDao<T> {

    List<T> queryList();

    T queryByPrimaryKey(String primaryKey);

    void add(T t);

    void update(T t);

    void delete(String primaryKey);

}
