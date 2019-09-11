package com.ocoyue.cloud.p1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Zoé
 * @date: 2019/9/11 上午10:19
 * @describe: TODO
 */
@RestController
public class HelloWorldController {

    @GetMapping(path = "h")
    public String m1(){

        return "hello world";
    }


}
