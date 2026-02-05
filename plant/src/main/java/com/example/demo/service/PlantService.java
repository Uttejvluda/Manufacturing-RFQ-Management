package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Demand;
import com.example.demo.model.Part;
import com.example.demo.model.PartPojo;
import com.example.demo.model.PlantReorderDetails;
import com.example.demo.model.ReorderRules;
import com.example.demo.model.Result;
import com.example.demo.repository.DemandRepo;
import com.example.demo.repository.PartRepo;
import com.example.demo.repository.PlantReorderRepo;
import com.example.demo.repository.ReorderRulesRepo;
import com.example.demo.vo.rfqvo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PlantService {

	@Autowired
	private PartRepo partrepo;
	
	@Autowired
	private DemandRepo demandrepo;
	
	@Autowired
	private PlantReorderRepo prrepo;
	
	@Autowired
	private ReorderRulesRepo reorderrepo;
	
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	
	public PartPojo viewStockInHand(int partId) {
		log.info("Inside viewStockInHand of service");
		
		int partid = partrepo.getById(partId).getPartId();
		String partDescription = partrepo.getById(partId).getPartDescription();
		String partSpecification = partrepo.getById(partId).getPartSpecification();
		Integer stockInHand = partrepo.getById(partId).getStockInHand();
		PartPojo pp = new PartPojo(partid,partDescription,partSpecification,stockInHand);
		return pp;
	}
	
	public List<Part> findAllPartsInReorder() {
		log.info("Inside findAllPartsInReorder of plant service");
		List<Part> partreorders = new ArrayList<>();
		List<PlantReorderDetails> plantlist = prrepo.findAll();
		if(plantlist.size()==0) {
			updatePartReorder();
			plantlist=prrepo.findAll();
		}
		for(PlantReorderDetails p: plantlist) {
			partreorders.add(p.getPart());
		}
		return partreorders;
	}
	
	public void updatePartReorder(){
		log.info("Inside findAllPartsInReorder of plant service");
		List<PlantReorderDetails> plantReorderDetailsTemporaryList = new ArrayList<>();
		List<Part> partreorder = partrepo.findAll();
		LocalDate date =null;
		prrepo.deleteAll();
		for (Part part : partreorder) {
			PlantReorderDetails prds = new PlantReorderDetails();
			if(part.getStockInHand()<part.getReorderrule().getMinQuantity()) {
				plantReorderDetailsTemporaryList = prrepo.findByPartPartId(part.getPartId());
				if(plantReorderDetailsTemporaryList.size()!=0) {
					prds.setPrdid(plantReorderDetailsTemporaryList.get(0).getPrdid());
				}
				prds.setPart(part);
				prds.setReorderStatus("pending");
				prds.setReorderdate(date);
				prrepo.save(prds);
			}
		}
	}
	
	public Result updateMinAndMax(int partid,int min,int max) {
		List<ReorderRules> p = reorderrepo.findByPartPartId(partid);

		Result res = null;
		ReorderRules reorderRulesTemplate = reorderrepo.getById(partid);
		if (reorderRulesTemplate != null) {
			Optional<Demand> demand = demandrepo.findById(reorderRulesTemplate.getDemandId());
			Integer minQuantity = min;
			Integer maxQuantity = max;
			if (maxQuantity < (demand.get().getDemandCount() * 20) / 100)
				reorderRulesTemplate.setMaxQuantity(max);
			else {
				res = new Result("Maximum");
				return res;
			}
			if (minQuantity > (maxQuantity * 30) / 100 && minQuantity < (maxQuantity * 50) / 100)
				reorderRulesTemplate.setMinQuantity(min);
			else {
				res = new Result("Minimum");
				return res;
			}
			reorderRulesTemplate.setReorderFrequency(max - min);
			reorderrepo.save(reorderRulesTemplate);
			updatePartReorder();
			res = new Result("Updated");
			return res;
		} else
			res = new Result("PartId not found. Please provide valid partId to update min and max quantities");
		return res;
	}
	

	public ReorderRules findById(Integer partId) {
		return  reorderrepo.findByPartPartId(partId).get(0);
	}
	
	public void save(ReorderRules reorderRules) {
		log.info("Inside save of PartService");
		 reorderrepo.save(reorderRules);
	}
	
	public Optional<Demand> findByDemandId(Integer demandId) {
		log.info("Inside findByDemandId of PartService");
		return demandrepo.findById(demandId);
	}
	
	public List<rfqvo> getRfqvo(){
		List<rfqvo> rfqlist = new ArrayList<>();
		List<PlantReorderDetails> parts = prrepo.findAll();
		for(PlantReorderDetails part:parts) {
			rfqvo rfq =new rfqvo();
			rfq.setPartName(part.getPart().getPartDescription());
			rfq.setPartId(part.getPart().getPartId());
			rfq.setSpecification(part.getPart().getPartSpecification());
			rfq.setDemandid(demandrepo.findByPartPartId(part.getPart().getPartId()).get(0).getDemandId());
			rfq.setQuantity(1);
			rfq.setTimetoSupply(1);
			rfqlist.add(rfq);
		}
		return rfqlist;
	}
}
