package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.feign.authfeign;
import com.example.demo.feign.plantfeign;
import com.example.demo.feign.supplierfeign;
import com.example.demo.model.rfq;
import com.example.demo.service.rfqservice;
import com.example.demo.vo.SupplierVo;





@RestController
@RequestMapping("/rfq")
@CrossOrigin(origins="*")
public class rfqcontroller {
	
	@Autowired
	private supplierfeign supplierfeign;
	
	@Autowired
	private rfqservice rfqserv;
	
	@Autowired
	private plantfeign plantFeign;
	
	@GetMapping("/getPotentialVendorsOfRFQ/{rfqId}")
	public ResponseEntity<List<SupplierVo>> getvendors(@PathVariable int rfqId){
		rfq r = rfqserv.getrfqlist(rfqId);
		String partName = r.getPartName();
		System.out.println(partName);
		List<SupplierVo> lsupplier = supplierfeign.getSupplierOfPart(partName,partName).getBody();
		System.out.println(lsupplier);
		List<SupplierVo> bestsupplier = new ArrayList<>();
		for(SupplierVo s:lsupplier) {
			if(s.getFeedback()>7) {
				bestsupplier.add(s);
			}
		}
	 return new ResponseEntity<List<SupplierVo>>(bestsupplier, HttpStatus.OK);
	}
	
	@GetMapping("/getRFQOfPlant")
	public ResponseEntity<List<rfq>> getRFQ(){
		List<rfq> rfqlist = plantFeign.getRFQDetails();
		for(rfq r:rfqlist) {
			rfqserv.addrfq(r);
		}
		List<rfq> rfqList = rfqserv.getRFQList();
 		return new ResponseEntity<List<rfq>>(rfqList, HttpStatus.OK);
	}

}
