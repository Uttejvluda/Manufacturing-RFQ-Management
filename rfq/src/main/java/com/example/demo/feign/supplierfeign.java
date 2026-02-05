package com.example.demo.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.demo.vo.SupplierVo;





@FeignClient(url = "http://localhost:8080", name = "SUPPLIER-CLIENT")
public interface supplierfeign {
	@GetMapping("/supplier/getSupplierOfPart/{partName}")
	public ResponseEntity<List<SupplierVo>> getSupplierOfPart(@RequestHeader("Authorization") String authorization,@PathVariable String partName);
}
