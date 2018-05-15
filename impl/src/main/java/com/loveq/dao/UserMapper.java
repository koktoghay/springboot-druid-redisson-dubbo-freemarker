package com.loveq.dao;

import com.enterprise.data.mapper.CrudMapper;
import com.loveq.domain.User;
import com.loveq.domain.dto.UserDTO;
import com.loveq.domain.vo.user.UserVO;

import java.util.List;

public interface UserMapper extends CrudMapper<User, Integer> {

    List<UserDTO> listUser(UserVO userVO);

    Long listUser_COUNT(UserVO userVO);
}
