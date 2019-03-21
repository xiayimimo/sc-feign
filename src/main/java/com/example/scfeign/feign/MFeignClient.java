package com.example.scfeign.feign;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.scfeign.feign.config.MFeignConfig;

@org.springframework.cloud.netflix.feign.FeignClient(name = "springcloud-provider-config",fallback = MFeignClientFallback.class, configuration = MFeignConfig.class)
public interface MFeignClient {
    // 这是被请求微服务的地址，也就是provider的地址
    @GetMapping(value = "/user/{id}")
    Object getUser(@PathVariable("id") String id);

    //新版本支持使用GetMapping，之前的老版本可能不支持
    @GetMapping(value = "/user/list")
    List<Object> getUsers();
    @GetMapping(value = "/user/test")
    String getString();
}
