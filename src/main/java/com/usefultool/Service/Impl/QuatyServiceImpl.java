package com.usefultool.Service.Impl;


import com.usefultool.Service.QuatyService;
import com.usefultool.Util.InfluxDbUtil;
import org.influxdb.dto.QueryResult;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class QuatyServiceImpl implements QuatyService {
    private InfluxDbUtil influxDB;

    @Override
    public void intoDb(String info, String df, Object code1, Object code2) {

        influxDB = InfluxDbUtil.setUp();

        Map<String,String> tags = new HashMap<>();
        Map<String,Object> fields = new HashMap<>();

        tags.put("tag1", info);
        tags.put("tag2", df);

        fields.put("field1",code1);
        fields.put("field2",code2);
//        fields.put("TIMAMPEST", df.format(String.valueOf(new Date())));
        influxDB.insert(tags, fields);

//        System.out.println(influxDB.query("select * from cpu"));

    }

    @Override
    public QueryResult getmsg(String command) {
        influxDB = InfluxDbUtil.setUp();
        return influxDB.query(command);

    }
}
