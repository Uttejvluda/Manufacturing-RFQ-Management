package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "http://localhost:8083", name = "AUTH-CLIENT")
public interface authfeign {
	 @GetMapping("/getuname")
	 public String getUname(@RequestHeader("Authorization") String authorization);
}
