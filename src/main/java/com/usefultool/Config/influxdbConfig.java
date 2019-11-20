package com.usefultool.Config;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Data
@Configuration
public class influxdbConfig {

    @Value("${spring.influx.database:''}")
    private String influxDatabase;

    @Value("${spring.influx.url:''}")
    private String influxUrl;

    @Value("${spring.influx.user:''}")
    private String influxUser;

    @Value("${spring.influx.password:''}")
    private String influxPassword;


//    @Bean
//    public InfluxDBUtils influxDBUtils

//    @Bean
//    public InfluxDB influxDB(){
//        InfluxDB influxDB = InfluxDBFactory.connect(influxUrl);
//        BiConsumer<Iterable<Point>, Throwable> exceptionHandler = (batch, exception) -> {
//            //批量插入失败
//            log.error("influxDB 入库失败，请查看");
//            exception.printStackTrace();
//        };
//        // 设置批量插入，满足条件1000条开始插入，每一秒插入一次
//        BatchOptions options = BatchOptions.DEFAULTS.bufferLimit(5000).actions(100).flushDuration(1000).jitterDuration(20);
//        //开启批量插入
//        influxDB.enableBatch(options);
//        influxDB.setDatabase(influxDatabase);
//        return influxDB;
//    }


}
