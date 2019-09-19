package com.hayes.hayesclient.ctrl;

import dto.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.HelloService;

@RestController
public class RefactorController implements HelloService {
    @Override
    public String hello(@RequestParam("name") String name) {
        return "hello "+name;
    }

    @Override
    public User hello(@RequestHeader("name") String name,@RequestHeader("age") Integer age) {
        return new User(name,age);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "hello "+user.getName()+","+user.getAge();
    }
}
