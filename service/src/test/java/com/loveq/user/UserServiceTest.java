package com.loveq.user;

import cn.hutool.core.util.RandomUtil;
import com.enterprise.data.type.DBEnum;
import com.github.pagehelper.PageInfo;
import com.loveq.domain.Sex;
import com.loveq.domain.User;
import com.loveq.domain.UserLoveState;
import com.loveq.domain.UserStatus;
import com.loveq.domain.dto.UserDTO;
import com.loveq.domain.vo.user.UserVO;
import com.loveq.launch.AbstractBaseTest;
import com.loveq.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class UserServiceTest extends AbstractBaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void testEnumOf() throws Exception {
        DBEnum dbEnum = Enum.valueOf(UserStatus.class, "LOGIN_LOCKED");
        Assert.assertNotNull(dbEnum);
    }

    @Test
    public void testCreateUser() throws Exception {
        User user = new User();
        user.setUserNo(RandomUtil.randomUUID());
        user.setAutoCheckNo(RandomUtil.randomUUID());
        user.setMobile("15905160228");
        user.setPassword("123456");
        user.setCreateTime(new Date());
        user.setStatus(UserStatus.NORMAL);
        user.setHeadIco("http://static.8dol.com/head/head_eight.png");
        user.setNickname("loveq");
        user.setSex(Sex.MALE);
        user.setLoveState(UserLoveState.NON_SINGLE);
        user.setUpgradeFlag(false);
        userService.createUser(user);
    }

    @Test
    public void testCreateUserSelective() throws Exception {
        User user = new User();
        user.setUserNo(RandomUtil.randomUUID());
        user.setAutoCheckNo(RandomUtil.randomUUID());
        user.setMobile("15901210229");
        user.setPassword("123456");
        user.setCreateTime(new Date());
        user.setStatus(UserStatus.LOGIN_LOCKED);
        user.setHeadIco("http://static.8dol.com/head/head_eight.png");
        user.setNickname("小殷桃");
        user.setSex(Sex.FEMALE);
        user.setLoveState(UserLoveState.SINGLE);
        user.setUpgradeFlag(false);
        userService.createUserSelective(user);
    }

    @Test
    public void batchCreateUser() throws Exception {
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setUserNo(RandomUtil.randomUUID());
        user1.setAutoCheckNo(RandomUtil.randomUUID());
        user1.setMobile("15905161111");
        user1.setPassword("62717771");
        user1.setCreateTime(new Date());
        user1.setStatus(UserStatus.NORMAL);
        user1.setHeadIco("http://static.8dol.com/head/head_eight.png");
        user1.setNickname("weeis");
        user1.setSex(Sex.MALE);
        user1.setLoveState(UserLoveState.NON_SINGLE);
        user1.setUpgradeFlag(true);

        User user2 = new User();
        user2.setUserNo(RandomUtil.randomUUID());
        user2.setAutoCheckNo(RandomUtil.randomUUID());
        user2.setMobile("15922261111");
        user2.setPassword("1231d3ss");
        user2.setCreateTime(new Date());
        user2.setStatus(UserStatus.NORMAL);
        user2.setHeadIco("http://static.8dol.com/head/head_eight.png");
        user2.setNickname("sksiq");
        user2.setSex(Sex.MALE);
        user2.setLoveState(UserLoveState.NON_SINGLE);
        user2.setUpgradeFlag(true);

        userList.add(user1);
        userList.add(user2);

        userService.batchCreateUser(userList);
    }

    @Test
    public void updateById() throws Exception {
        User user = userService.getUserById(1);
        user.setStatus(UserStatus.DELETED);
        userService.updateUserById(user);
    }

    @Test
    public void updateUserSelective() throws Exception {
        User user = new User();
        user.setId(1);
        user.setStatus(UserStatus.NORMAL);
        userService.updateUserSelective(user);
    }

    @Test
    public void testGetUserById() throws Exception {
        User user = userService.getUserById(1);
        Assert.assertNotNull(user);
        Assert.assertEquals("15901210228", user.getMobile());
    }

    @Test
    public void testPageQuery() throws Exception {
        User user = new User();
        user.setNickname("loveq");
        PageInfo<User> userPageInfo = userService.listPageUser(user);
        if (userPageInfo != null) {
            Assert.assertEquals(1, userPageInfo.getList().size());
        }
    }

    @Test
    public void testQueryAll() throws Exception {
        List<User> user = userService.list();
        Assert.assertEquals(4, user.size());
    }

    @Test
    public void testListUser() throws Exception {
        UserVO userVO = new UserVO();
        userVO.setNickname("loveq");
        PageInfo<UserDTO> userDTOPageInfo = userService.listUser(userVO);
        if (userDTOPageInfo != null) {
            Assert.assertEquals(1, userDTOPageInfo.getList().size());
        }
    }

}
