package com.usefultool;


import com.usefultool.Module.test_redis;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import javax.annotation.Resource;

@SpringBootTest
public class RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;


    @Resource
    private ValueOperations<String,Object> valueOperations;

    @Autowired
    private HashOperations<String, String, Object> hashOperations;

    @Autowired
    private ListOperations<String, Object> listOperations;

    @Autowired
    private SetOperations<String, Object> setOperations;

    @Autowired
    private ZSetOperations<String, Object> zSetOperations;


    @Test
    void insert_redis(){

        test_redis test_redis = new test_redis();
//        test_redis.setName("zccrazy66");
//        test_redis.setAge(23);
//        test_redis.setAddress("shanghai");
//
//        valueOperations.set("22",test_redis);
        String back = valueOperations.get("22").toString();

        System.out.println(back);
    }

}
