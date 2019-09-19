package com.hayes.hayesclient.ctrl;

import dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.logging.Logger;

@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));

    @Autowired
    private DiscoveryClient client ;

    @RequestMapping("/hello")
    public String index() throws InterruptedException {

        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello , host:"+instance.getHost()+", server_id:"+instance.getServiceId() );

        int anInt = new Random().nextInt(3000);
        logger.info("sleep: "+anInt);

        Thread.sleep(anInt);

        return "/hello , host:"+instance.getHost()+", server_id:"+instance.getServiceId() ;

    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name ){
        return "hello "+name ;
    }
    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name , @RequestHeader Integer age ){
        return new User(name , age ) ;
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user ){
        return "hello name:"+user.getName()+", age: "+user.getAge() ;
    }








}
