package com.usefultool;

import com.alibaba.fastjson.JSONObject;
import com.usefultool.Module.SenorRtData;
import com.usefultool.Module.test_redis;
import com.usefultool.Service.QuatyService;
import com.usefultool.Util.InfluxDbUtil;
import org.influxdb.dto.QueryResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class InfluxDBApplicationTests {
    private InfluxDbUtil influxDB;

    @Autowired
    QuatyService quatyService;


    @Test
    // 插入传感器实时数据
    void insert_SensorRtData_DB(){
        // 封装的实体类
        SenorRtData senorRtData = new SenorRtData();
        // 待输入的tags和fields
        Map<String,String> tags = new HashMap<>();
        Map<String,Object> fields = new HashMap<>();
        // 获取tags
        tags.put("sensorId",String.valueOf(senorRtData.getSenorId()));
        tags.put("channel",String.valueOf(senorRtData.getChannel()));
        // 获取fields
        fields.put("waveCtr",senorRtData.getWaveCtr());
        fields.put("coefficient",senorRtData.getCoefficient());
        fields.put("frequency",senorRtData.getFrequency());
        fields.put("sampleNum",senorRtData.getSampleNum());
        fields.put("effectiveValue",senorRtData.getEffectiveValue());
        fields.put("peek",senorRtData.getPeek());
        fields.put("peekToPeek",senorRtData.getPeekToPeek());
        fields.put("temperature",senorRtData.getTemperature());
        // 获取时间
        long gmt = senorRtData.getGmt();
        // 插入数据库
        quatyService.intoDb(tags,fields,gmt,TimeUnit.MILLISECONDS);
        // test
        System.out.println("insert success");
    }

    @Test
        // 测试插入list
    void test_list(){
        // 声明 & 制造
        double a = 1.23;
        Map<String,String> tags = new HashMap<>();
        Map<String,Object> fields = new HashMap<>();
        List<Double> dataList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            a++;
            dataList.add(a);
        }
        // 添加 series
        tags.put("TAGS_TEST","TEST_INSERT_LIST");
        fields.put("test_double",dataList.toString());
        long time = System.currentTimeMillis();

        quatyService.intoDb(tags,fields,time,TimeUnit.MILLISECONDS);
        System.out.println("insert success!");

    }

    @Test
    // 取数组测试
    void get_from_influxdb(){
        // 查询
        QueryResult result = quatyService.getmsg("select test_double from cz");

        // 取得结果list
        List<QueryResult.Result> list = result.getResults();
        // 获取想要的value 这边拿一个链表，在influxdb中是以string类型存储的
        String a = (String) list.get(0).getSeries().get(0).getValues().get(0).get(1);
        // 转换为数组
        String[] str =  a.substring(1,a.length()-1).split(", ");
        // String数组转Integer类型的list
        List<Double> list1 = new LinkedList<>();
        for (int i = 0; i < str.length; i++) {
            list1.add(Double.valueOf(str[i]));
        }
        System.out.println(list1);
    }


    @Test
    // 第一次测试influxdb
    void test_influxDB() {

        System.out.println("hehe");
//        quatyService.intoDb("0","1",2,9);
//        System.out.println(Arrays.toString(db));
//        long startTime =  System.currentTimeMillis();


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



}

