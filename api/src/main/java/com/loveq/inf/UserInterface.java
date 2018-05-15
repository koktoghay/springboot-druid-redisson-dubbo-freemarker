package com.loveq.inf;

import com.loveq.domain.User;
import com.loveq.exception.ServiceException;

public interface UserInterface {

    int createUser(User user) throws ServiceException;

    User getUserById(Integer id) throws ServiceException;
}
