package com.influxdb.Service.Impl;


import com.influxdb.Service.QuatyService;
import com.influxdb.Util.InfluxDbUtil;
import org.influxdb.dto.QueryResult;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class QuatyServiceImpl implements QuatyService {
    private InfluxDbUtil influxDB;

    @Override
    public void intoDb(Map info, Object code, String df) {

        influxDB = InfluxDbUtil.setUp();
        Map<String,String> tags = new HashMap<>();
        Map<String,Object> fields = new HashMap<>();

        tags.put("TAG_NAME", info.toString());
        fields.put("TAG_VALUE",code);
        fields.put("TIMAMPEST", df.format(String.valueOf(new Date())));
        influxDB.insert(tags, fields);

//        System.out.println(influxDB.query("select * from cpu"));

    }

    @Override
    public QueryResult getmsg(String command) {
        influxDB = InfluxDbUtil.setUp();
        return influxDB.query(command);

    }
}
