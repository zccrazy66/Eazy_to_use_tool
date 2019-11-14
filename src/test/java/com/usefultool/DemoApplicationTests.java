package com.usefultool;

import com.alibaba.fastjson.JSONObject;
import com.usefultool.Module.test_redis;
import com.usefultool.Service.QuatyService;
import com.usefultool.Util.InfluxDbUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {
    private InfluxDbUtil influxDB;

    @Autowired
    QuatyService quatyService;

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
    void contextLoads() {

        String info = "zc";
        Integer a = 2;

        quatyService.intoDb("0","1",2,9);
//        System.out.println(Arrays.toString(db));
//        long startTime =  System.currentTimeMillis();

//        influxDB = InfluxDbUtil.setUp();
//        Map<String,String> tags = new HashMap<>();
//        Map<String,Object> fields = new HashMap<>();
//
//        tags.put("region", info);
//        tags.put("type", "sd");
//        fields.put("value",a++);

//
//        for (int i = 0; i < 10000; i++) {
//            influxDB.insert(tags,fields);
//        }
//        System.out.println(quatyService.getmsg("select * from cpu where time>=1573454590456232300 and time<=1573454685111082900 ").toString());

//        where time>='2019-11-11T08:34:23.4878448Z' and time<='2019-11-11T08:36:57.8518015Z'

//        long endTime =  System.currentTimeMillis();
//        System.out.println(startTime);
//        System.out.println(endTime);
//
//        long usedTime = (endTime-startTime)/1000;
//        System.out.println(usedTime);
//        System.out.println(quatyService.getmsg("select * from cpu").toString());

    }

    @Test
    void cute(){

        RestTemplate restTemplate = new RestTemplate();
        String url="http://localhost:8086/query?pretty=true&q=select * from cpu order by time desc limit 2&db=test";
        // 返回的数据
        String list = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = JSONObject.parseObject(list);
        System.out.println(jsonObject);

//        JSONArray result = (JSONArray) jsonObject.get("results");
//        JSONObject series = (JSONObject) result.get(0);
//        JSONArray series_list = (JSONArray) series.get("series");
//        JSONObject series_list_2 = (JSONObject) series_list.get(0);
//        JSONArray value = (JSONArray) series_list_2.get("values");
////        System.out.println(value);
//        // JSONArray 转 String
//        String str = JSONObject.toJSONString(value);
//        List list1 = JSONObject.parseArray(str);

    }


    @Test
    void test_redis() throws Exception{
        valueOperations.set("1r3","heyw");
        System.out.println(valueOperations.get("1113"));
    }



}

