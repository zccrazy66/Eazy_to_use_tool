package com.usefultool.Service.Impl;


import com.usefultool.Service.QuatyService;
import com.usefultool.Util.InfluxDbUtil;
import org.influxdb.dto.QueryResult;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class QuatyServiceImpl implements QuatyService {
    private InfluxDbUtil influxDB;

    @Override
    public void intoDb(Map<String,String> tags, Map<String,Object> fields,long time, TimeUnit precisionToSet) {
        influxDB = InfluxDbUtil.setUp();
        influxDB.insert(tags, fields,time, TimeUnit.MILLISECONDS);
    }

    @Override
    public QueryResult getmsg(String command) {
        influxDB = InfluxDbUtil.setUp();
        return influxDB.query(command);

    }
}
