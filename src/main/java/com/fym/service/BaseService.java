package com.fym.service;

import java.util.List;

public interface BaseService<T> {

    /**
     * 查所有
     */
    List<T> selectAll();

    /**
     * 增
     */
    void add(T t);

    /**
     * 删
     */
    void delect(long id);

    /**
     * 改
     */
    void update(T t);

    /**
     * 查
     */
    T selectById(long id);
}
