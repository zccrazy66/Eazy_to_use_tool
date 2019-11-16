package com.usefultool.Service;

import org.influxdb.dto.QueryResult;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public interface QuatyService {

    void intoDb(Map<String,String> tags, Map<String,Object> fields, long time, TimeUnit precisionToSet);

    QueryResult getmsg(String command);

}
