package com.louis.service.impl;


import com.louis.dao.UserMapper;
import com.louis.pojo.User;
import com.louis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userDao;

    public User selectUserById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }
}
