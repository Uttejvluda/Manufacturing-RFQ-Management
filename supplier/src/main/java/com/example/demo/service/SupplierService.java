package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Supplier;
import com.example.demo.model.Supplier_part;
import com.example.demo.repository.SuppilerPartRepo;
import com.example.demo.repository.SupplierRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SupplierService {

	@Autowired
	private SupplierRepo srepo;

	@Autowired
	private SuppilerPartRepo sprepo;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public List<Supplier> getAllSupplier() {
		return srepo.findAll();
	}

	public List<Supplier> getAllSupplierByPartId(String partName) {
		List<Supplier> suppliers = new ArrayList<>();
		List<Supplier_part> parts = sprepo.findByPartname(partName);
		for (Supplier_part part : parts) {
			suppliers.add(part.getSupplier());
		}
		return suppliers;
	}

	public Supplier addSupplier(Supplier supplier) {
		log.info("Inside addSupplier of Supplier Service");
		System.out.println(supplier);
		return srepo.save(supplier);
	}

	public Supplier editSupplier(Supplier supplier) {
		log.info("Inside editSupplier of Supplier Service");
		Supplier updateSupplier = srepo.getById(supplier.getSupplier_id());
		if(updateSupplier != null) {
			return srepo.save(supplier);
		}
		return null;
		
	}

	public Supplier updateFeedback(Supplier supplier) {
		log.info("Inside update feedback of supplier service");
		Supplier updateSupplier = srepo.getById(supplier.getSupplier_id());
		if (updateSupplier != null) {
			updateSupplier.setFeedback(supplier.getFeedback());
			return srepo.save(updateSupplier);
		}
		return null;
	}

}
