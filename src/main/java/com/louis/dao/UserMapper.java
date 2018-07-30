package com.louis.dao;

import com.louis.pojo.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectByPage();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}