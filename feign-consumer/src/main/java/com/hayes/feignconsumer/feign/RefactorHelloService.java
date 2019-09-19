package com.hayes.feignconsumer.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import service.HelloService;

@FeignClient("hello-service")
public interface RefactorHelloService extends HelloService {
}
