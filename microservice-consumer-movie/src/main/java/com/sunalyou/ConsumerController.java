package com.sunalyou;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by ywq on 17/7/3.
 * mail y.wq@qq.com
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/hello")
    public String hello(){
        return "hello spring cloud";
    }

    @GetMapping("/hello2")
    public String hello2(){
        List<ServiceInstance> serviceList = this.discoveryClient.getInstances("microservice-provider-user");
        if (serviceList !=null && serviceList.size() > 0){
           ServiceInstance si = serviceList.get(0);
           return this.restTemplate.getForObject(si.getUri() +"/hello", String.class);
        }
        return "";
    }

    @GetMapping("/get/ints")
    public List<ServiceInstance> showInstance(){
        return this.discoveryClient.getInstances("microservice-provider-user");
    }
}
