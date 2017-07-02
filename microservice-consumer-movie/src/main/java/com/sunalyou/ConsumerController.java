package com.sunalyou;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ywq on 17/7/3.
 * mail y.wq@qq.com
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello(){
        return "hello spring cloud";
    }

    @GetMapping("/hello2")
    public String hello2(){
        return this.restTemplate.getForObject("http://localhost:8010/hello", String.class);
    }
}
