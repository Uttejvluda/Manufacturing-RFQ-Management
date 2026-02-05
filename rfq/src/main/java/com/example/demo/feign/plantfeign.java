package com.example.demo.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.demo.model.rfq;


@FeignClient(url = "http://localhost:8082", name = "PLANT-CLIENT")
public interface plantfeign {
	@GetMapping("/plant/getRFQ")//@RequestHeader("Authorization") String authorization
	public List<rfq> getRFQDetails();
}
