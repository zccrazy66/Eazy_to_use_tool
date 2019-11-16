package com.usefultool.Util;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Data
@Slf4j
public class InfluxDbUtil {

    private static String openurl = "http://localhost:8086";//连接地址
    private static String username = "zczc";//用户名
    private static String password = "123456";//密码
    private static String database = "test";//数据库
    private static String measurement = "cz";//表名

    private InfluxDB influxDB;


    public InfluxDbUtil(String username, String password, String openurl, String database){
        this.username = username;
        this.password = password;
        this.openurl = openurl;
        this.database = database;
    }

    public static InfluxDbUtil setUp(){
        //创建 连接
        InfluxDbUtil influxDbUtil = new InfluxDbUtil(username, password, openurl, database);
        influxDbUtil.influxDbBuild();
        influxDbUtil.createRetentionPolicy();
//
//   influxDB.deleteDB(database);
//   influxDB.createDB(database);
        return influxDbUtil;
    }

    /**连接时序数据库；获得InfluxDB**/
    public InfluxDB influxDbBuild(){
        if(influxDB == null){
            influxDB = InfluxDBFactory.connect(openurl, username, password);
            influxDB.createDatabase(database);
        }
        return influxDB;
    }

    /**
     * 设置数据保存策略
     * defalut 策略名 /database 数据库名/ 30d 数据保存时限30天/ 1 副本个数为1/ 结尾DEFAULT 表示 设为默认的策略
     */
    public void createRetentionPolicy(){
        String command = String.format("CREATE RETENTION POLICY \"%s\" ON \"%s\" DURATION %s REPLICATION %s DEFAULT",
                "defalut", database, "30d", 1);
        this.query(command);
    }

    /**
     * 查询
     * @param command 查询语句
     * @return
     */
    public QueryResult query(String command){
        return influxDB.query(new Query(command, database));
    }

    /**
     * 插入
     * @param tags 标签
     * @param fields 字段
     */
    public void insert(Map<String, String> tags, Map<String, Object> fields, long timeToSet, TimeUnit precisionToSet){
        Point.Builder builder = Point.measurement(measurement);
        builder.tag(tags);
        builder.fields(fields);
        if (0 != timeToSet){
            builder.time(timeToSet,precisionToSet);
        }

        influxDB.write(database, "", builder.build());
    }

    /**
     * 删除
     * @param command 删除语句
     * @return 返回错误信息
     */
    public String deleteMeasurementData(String command){
        QueryResult result = influxDB.query(new Query(command, database));
        return result.getError();
    }

    /**
     * 创建数据库
     * @param dbName
     */
    public void createDB(String dbName){
        influxDB.createDatabase(dbName);
    }

    /**
     * 删除数据库
     * @param dbName
     */
    public void deleteDB(String dbName){
        influxDB.deleteDatabase(dbName);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOpenurl() {
        return openurl;
    }

    public void setOpenurl(String openurl) {
        this.openurl = openurl;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

}
