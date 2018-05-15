package com.loveq.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.loveq.domain.User;
import com.loveq.exception.FrontendException;
import com.loveq.exception.ServiceException;
import com.loveq.inf.UserInterface;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by tommy on 2018/4/26.
 */
@RequestMapping("test")
@Controller
public class TestController {

    @Reference
    private UserInterface userInterface;

    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping("queryUserById")
    @ResponseBody
    public String queryUserById(@RequestParam("id") Integer id) throws FrontendException {
        try {
            User user = userInterface.getUserById(id);
            if (user != null) {
                RList<String> list = redissonClient.getList("userListJSONStringForFrontend");
                list.add(JSON.toJSONString(user));
            }

            return JSON.toJSONString(user);
        } catch (ServiceException e) {
            throw new FrontendException(e);
        }
    }

    @RequestMapping("/jumpToUserListPage")
    public String jumpToUserListPage(@RequestParam("id") Integer id, Map<String, Object> map) throws FrontendException {
        try {
            User user = userInterface.getUserById(id);
            map.put("user", user);
        } catch (ServiceException e) {
            throw new FrontendException(e);
        }
        return "user/userList";
    }

}
