package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.rfq;
import com.example.demo.repository.rfqRepository;

@Service
public class rfqservice {
	@Autowired
	private rfqRepository rfqrepo;
	
	
	public rfq addrfq(rfq r) {
		List<rfq> rf = rfqrepo.findAll();
		
		for(rfq rf1:rf) {
			if(rf1.getPartId() == r.getPartId()) {
				r.setRfqId(rf1.getRfqId());
				rfqrepo.save(r);
			}
				
		}
		
		return rfqrepo.save(r);
	}
	
	public List<rfq> getRFQList(){
		
		return rfqrepo.findAll();
	}
	
	public rfq getrfqlist(int id) {
		return rfqrepo.getById(id);
	}

}
