package com.usefultool;


import com.usefultool.Module.ReidsModule.Alarm;
import com.usefultool.Module.ReidsModule.Attribute;
import com.usefultool.Module.ReidsModule.Product;
import com.usefultool.Module.test_redis;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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

//        test_redis test_redis = new test_redis();
//        test_redis.setName("zccrazy66");
//        test_redis.setAge(23);
//        test_redis.setAddress("shanghai");
//
//        valueOperations.set("22",test_redis);
        Map<String,Object> map = new HashMap<>();
        map.put("key","code");
        Alarm alarm = new Alarm();
        Attribute attribute = new Attribute();
        Product product = new Product();
        alarm.setType("test_redis");
        alarm.setTime(1117);
        attribute.setMap(map);

        product.setAlarm(alarm);
        product.setAttribute(attribute);


        valueOperations.set("proAddr",product);

//        System.out.println(back);
    }

    @Test
    void design_the_table(){

    }



}
