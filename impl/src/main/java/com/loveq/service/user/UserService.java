package com.loveq.service.user;

import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageInfo;
import com.loveq.dao.UserMapper;
import com.loveq.domain.User;
import com.loveq.domain.constant.BusinessCode;
import com.loveq.domain.dto.UserDTO;
import com.loveq.domain.vo.user.UserVO;
import com.loveq.exception.ServiceException;
import com.loveq.service.AbstractPagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService extends AbstractPagerService {

    @Autowired
    private UserMapper userMapper;

    public int createUser(User user) throws ServiceException {
        if (user == null) {
            throw new ServiceException(BusinessCode.System.EXPECTATION_FAILED);
        }
        return userMapper.insert(user);
    }

    public int createUserSelective(User user) throws ServiceException {
        if (user == null) {
            throw new ServiceException(BusinessCode.System.EXPECTATION_FAILED);
        }
        return userMapper.insertSelective(user);
    }

    public int batchCreateUser(List<User> userList) throws ServiceException {
        if (CollUtil.isEmpty(userList)) {
            throw new ServiceException(BusinessCode.System.EXPECTATION_FAILED);
        }
        return userMapper.batchInsert(userList);
    }

    public int updateUserById(User user) throws ServiceException {
        if (user == null) {
            throw new ServiceException(BusinessCode.System.EXPECTATION_FAILED);
        }
        return userMapper.updateById(user);
    }

    public int updateUserSelective(User user) throws ServiceException {
        if (user == null) {
            throw new ServiceException(BusinessCode.System.EXPECTATION_FAILED);
        }
        return userMapper.updateBySelective(user);
    }

    public User getUserById(Integer id) throws ServiceException {
        if (id == null) {
            throw new ServiceException(BusinessCode.System.EXPECTATION_FAILED);
        }
        return userMapper.getById(id);
    }

    public PageInfo<User> listPageUser(User user) throws ServiceException {
        if (user == null) {
            throw new ServiceException(BusinessCode.System.EXPECTATION_FAILED);
        }
        return page(user, new PageQuery<User, User>() {
            @Override
            public List<User> doQuery(User queryBean) {
                return userMapper.listByEntityWhere(user);
            }
        });
    }

    public List<User> list() {
        return userMapper.list();
    }

    public PageInfo<UserDTO> listUser(UserVO userVO) throws ServiceException {
        if (userVO == null) {
            throw new ServiceException(BusinessCode.System.EXPECTATION_FAILED);
        }
        return page(userVO, new PageQuery<UserDTO, UserVO>() {

            @Override
            public List<UserDTO> doQuery(UserVO queryBean) {
                return userMapper.listUser(userVO);
            }
        });
    }
}
