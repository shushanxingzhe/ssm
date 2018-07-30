package com.louis.service;

import com.louis.pojo.User;

import java.util.List;


public interface IUserService {

    User selectUserById(Integer id );

    List<User> selectByPage(Integer page,Integer pageSize);
}
