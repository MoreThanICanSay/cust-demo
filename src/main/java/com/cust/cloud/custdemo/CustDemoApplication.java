package com.cust.cloud.custdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class CustDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustDemoApplication.class, args);
    }

    @Value("${myname:config server not found}")
    private String myname;

    @Value("${server.port}")
    private String port;

    //访问/hello或者/hi任何一个地址，都会返回一样的结果
    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    public String say(@RequestParam(value = "name", defaultValue = "z") String name) {
        return "hi you!!!" + myname + " and " + name + " and port is " + port;
    }
}
