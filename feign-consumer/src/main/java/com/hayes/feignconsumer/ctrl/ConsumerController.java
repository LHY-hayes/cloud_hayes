package com.hayes.feignconsumer.ctrl;

import com.hayes.feignconsumer.feign.HelloService;
import com.hayes.feignconsumer.feign.RefactorHelloService;
import dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService ;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.hello();
    }
    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2(){
        StringBuilder sb = new StringBuilder() ;
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("DIDI")).append("\n");
        sb.append(helloService.hello("DIDI",25)).append("\n");
        sb.append(helloService.hello(new User("DIDI",30))).append("\n");


        return sb.toString() ;

    }


    /******************************************************************************************************/


    @Autowired
    private RefactorHelloService refactorHelloService ;

    @RequestMapping(value = "/feign-consumer3",method = RequestMethod.GET)
    public String helloConsumer3(){
        StringBuilder sb = new StringBuilder() ;
        sb.append(refactorHelloService.hello("MIMI")).append("\n");
        sb.append(refactorHelloService.hello("MIMI",25)).append("\n");
        sb.append(refactorHelloService.hello(new User("MIMI",30))).append("\n");

        return sb.toString() ;
    }





}
