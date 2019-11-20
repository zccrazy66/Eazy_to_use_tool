package com.usefultool.Service.Impl;


import com.usefultool.Service.HttpService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class HttpServiceImpl implements HttpService {
    @Override
    public Map<String, Object> rest_post(Map param) {

        // 先不用
        Map<String, Object> map = new HashMap<>();

        RestTemplate restTemplate = new RestTemplate();

        String url="http://localhost:8086/query?pretty=true&q=select * from pkk&db=mydb";

        String points=restTemplate.getForObject(url,String.class);

        System.out.println("points:"+points);

        return map;
    }
}
