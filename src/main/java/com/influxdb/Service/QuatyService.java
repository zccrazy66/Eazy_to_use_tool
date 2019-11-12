package com.influxdb.Service;

import org.influxdb.dto.QueryResult;

import java.util.Map;

public interface QuatyService {

    void intoDb(Map<String, String> map, Object code, String time);

    QueryResult getmsg(String command);

}
