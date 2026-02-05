package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.example.demo.model.Part;
import com.example.demo.model.PartPojo;
import com.example.demo.service.PlantService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class PlantControllerTest {
	
	@MockBean
	private PlantService plantService;
	
	@MockBean
	private authfeign authFeign;
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;
	
	private Part part1 = new Part(1,"asd","sda",10);
	private Part part2 = new Part(2,"aed","sda",10);
	private Part part3 = new Part(3,"ard","sda",10);
	
	private PartPojo partpojo = new PartPojo(1,"asd","sda",10);

	@Test
	void getAllPartReordersTestSuccess() throws Exception{
		Map<String,String> map = new HashMap<>();
		map.put("Authorization", "helloddvjdh");
		HttpHeaders httpheader = new HttpHeaders();
		httpheader.setAll(map);
		List<Part> partList = new ArrayList<>();
		partList.add(part1);
		partList.add(part2);
		partList.add(part3);
		Mockito.when(plantService.findAllPartsInReorder()).thenReturn(partList);
		mockMvc.perform(MockMvcRequestBuilders.get("/plant/viewPartsReOrder").headers(httpheader).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	@Test
	void getStockSuccess() throws Exception{
		Map<String,String> map = new HashMap<>();
		map.put("Authorization", "helloddvjdh");
		HttpHeaders httpheader = new HttpHeaders();
		httpheader.setAll(map);
		Mockito.when(plantService.viewStockInHand(Mockito.anyInt())).thenReturn(partpojo);
		String json = mapper.writeValueAsString(partpojo);
		mockMvc.perform(MockMvcRequestBuilders.get("/plant/viewStockInHand/1").headers(httpheader).contentType(MediaType.APPLICATION_JSON).content(json))
		.andExpect(status().isOk());
	}
	
	@Test
	void getStockFail() throws Exception{
		Map<String,String> map = new HashMap<>();
		map.put("Authorization", "helloddvjdh");
		HttpHeaders httpheader = new HttpHeaders();
		httpheader.setAll(map);
		Mockito.when(plantService.viewStockInHand(Mockito.anyInt())).thenReturn(null);
		mockMvc.perform(MockMvcRequestBuilders.get("/plant/viewStockInHand/2").headers(httpheader))
		.andExpect(status().isNotFound());
	}
	


}
