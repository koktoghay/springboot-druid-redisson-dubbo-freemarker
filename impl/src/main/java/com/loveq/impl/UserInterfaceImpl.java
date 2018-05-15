package com.loveq.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.loveq.domain.User;
import com.loveq.exception.ServiceException;
import com.loveq.inf.UserInterface;
import com.loveq.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class UserInterfaceImpl implements UserInterface {

    @Autowired
    private UserService userService;

    @Override
    public int createUser(User user) throws ServiceException {
        return userService.createUser(user);
    }

    @Override
    public User getUserById(Integer id) throws ServiceException {
        return userService.getUserById(id);
    }
}
