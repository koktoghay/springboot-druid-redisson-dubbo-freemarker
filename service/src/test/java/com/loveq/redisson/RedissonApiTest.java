package com.loveq.redisson;

import com.alibaba.fastjson.JSON;
import com.loveq.domain.User;
import com.loveq.launch.AbstractBaseTest;
import com.loveq.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.redisson.api.RList;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * Created by tommy on 2018/4/25.
 */
@Slf4j
public class RedissonApiTest extends AbstractBaseTest {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private UserService userService;

    @Test
    public void testQueryAllKeys() throws Exception {

        Collection<String> keysCollections = redissonClient.getKeys().findKeysByPattern("shouhuowang_trade_logs_*");

        Assert.assertNotNull(keysCollections);

    }

    @Test
    public void testQueryRedisZSetData() throws Exception {
        RScoredSortedSet<String> rScoredSortedSet = redissonClient.getScoredSortedSet("shouhuowang_trade_logs_438031715212689568640122");
        Assert.assertNotNull(rScoredSortedSet);
        String st = rScoredSortedSet.first();
        log.info("firstStr:{}", st);
    }

    @Test
    public void testSetRedisListData() throws Exception {
        User user = userService.getUserById(1);
        if (user != null) {
            RList<String> list = redissonClient.getList("userListJSONString");
            list.add(JSON.toJSONString(user));
        }
    }

    @Test
    public void testGetRedisListData() throws Exception {
        RList<String> list = redissonClient.getList("userListJSONString");
        for (String user : list) {
            log.info("userJSON:{}", JSON.parseObject(user, User.class));
        }
    }
}
