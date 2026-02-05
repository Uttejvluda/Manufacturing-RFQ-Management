package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.feign.authfeign;
import com.example.demo.model.Part;
import com.example.demo.model.PartPojo;
import com.example.demo.model.Result;
import com.example.demo.service.PlantService;
import com.example.demo.vo.rfqvo;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/plant")
@CrossOrigin(origins = "*")
@Slf4j
public class PlantController {

	@Autowired
	private PlantService pserv;

	@GetMapping(value = "/viewPartsReOrder", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Part>> viewPartsReorder() {
		
		List<Part> partList = pserv.findAllPartsInReorder();
		if (partList.isEmpty()) {
			throw new NoSuchElementException();
		}
		return new ResponseEntity<List<Part>>(partList, HttpStatus.OK);
	}

	@GetMapping("/viewStockInHand/{partId}")
	public ResponseEntity<PartPojo> viewStockInHand(@PathVariable int partId) {
		
		PartPojo part = pserv.viewStockInHand(partId);
		if (part == null) {
			return new ResponseEntity<PartPojo>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PartPojo>(part, HttpStatus.OK);
	}

	@PutMapping("/updateMinMaxQuantity/{id}/{min}/{max}") 
	public ResponseEntity<Result> updateMinMaxQuantities(@PathVariable(value = "id") int id,
			@PathVariable(value = "min") int min, @PathVariable(value = "max") int max) {
		
		Result res = pserv.updateMinAndMax(id, min, max);
		
		return new ResponseEntity<Result>(res, HttpStatus.OK);
	}

	@GetMapping("/getRFQ") 
	public List<rfqvo> getRFQDetails() {
		return pserv.getRfqvo();
	}
}
