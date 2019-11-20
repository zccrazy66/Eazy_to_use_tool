package com.usefultool.Controller;


import com.usefultool.Util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DcsControllerTest {


//
//    @PostMapping
//    @ResponseBody
    @RequestMapping("/houa")
    @ResponseBody
    public String test(){
        System.out.println("into it");
        return "test";
    }




}
