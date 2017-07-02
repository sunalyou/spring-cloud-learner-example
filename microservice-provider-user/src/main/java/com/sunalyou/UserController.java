package com.sunalyou;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ywq on 17/7/2.
 * mail y.wq@qq.com
 */
@RestController
public class UserController {
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
