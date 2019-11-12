package com.influxdb;

import com.influxdb.Service.QuatyService;
import com.influxdb.Util.InfluxDbUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    QuatyService quatyService;

    @Test
    void contextLoads() {

        Map<String,String> map = new HashMap<>();
        map.put("zczc", "zc111zc");
        Integer a = 300002;
//        System.out.println(Arrays.toString(db));

        long startTime =  System.currentTimeMillis();

        for (int i = 300002; i < 400000; i++) {
            a++;
            quatyService.intoDb(map, a.toString(),"23");
        }
//        System.out.println(quatyService.getmsg("select * from cpu where time>='2019-11-11T08:34:23.4878448Z' and time<='2019-11-11T08:36:57.8518015Z'  ").toString());


        long endTime =  System.currentTimeMillis();
        System.out.println(startTime);
        System.out.println(endTime);

        long usedTime = (endTime-startTime)/1000;
        System.out.println(usedTime);
//        System.out.println(quatyService.getmsg("select * from cpu").toString());

    }

    @Test
    void cute(){



    }



}
