package com.usefultool.Service;

import org.influxdb.dto.QueryResult;

public interface QuatyService {

    void intoDb(String tag1, String tag2, Object field1,  Object field2);

    QueryResult getmsg(String command);

}
