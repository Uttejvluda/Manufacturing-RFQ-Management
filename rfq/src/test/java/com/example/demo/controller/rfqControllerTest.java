package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.feign.authfeign;
import com.example.demo.model.rfq;
import com.example.demo.service.rfqservice;
import com.example.demo.vo.SupplierVo;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class rfqControllerTest {
	
	@MockBean
	private rfqservice rfqService;
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private authfeign authFeign;
	
	@Autowired
	ObjectMapper mapper;
	
	private rfq rfq1 = new rfq(1,1,1,10,"asd",10,"eds");
	private rfq rfq2 = new rfq(2,2,2,10,"ase",10,"eas");
	private rfq rfq3 = new rfq(3,3,2,10,"asf",10,"ews");
	

	@Test
	void getAllRFQTestSuccess() throws Exception{
//		Map<String,String> map = new HashMap<>();
//		map.put("Authorization", "helloddvjdh");
//		HttpHeaders httpheader = new HttpHeaders();
//		httpheader.setAll(map);
//		List<rfq> supplierList = new ArrayList<>();
//		supplierList.add(rfq1);
//		supplierList.add(rfq2);
//		supplierList.add(rfq3);
//		Mockito.when(rfqService.getRFQList()).thenReturn(supplierList);
//		mockMvc.perform(MockMvcRequestBuilders.get("/rfq/getRFQOfPlant").headers(httpheader).contentType(MediaType.APPLICATION_JSON))
//		.andExpect(status().isOk());
	}

		
}
