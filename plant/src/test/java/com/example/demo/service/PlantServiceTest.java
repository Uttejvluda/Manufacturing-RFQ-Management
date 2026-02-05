package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.demo.model.Part;
import com.example.demo.model.PartPojo;
import com.example.demo.model.PlantReorderDetails;
import com.example.demo.model.ReorderRules;
import com.example.demo.repository.DemandRepo;
import com.example.demo.repository.PartRepo;
import com.example.demo.repository.ReorderRulesRepo;

class PlantServiceTest {

	@InjectMocks
	private PlantService plantService;
	
	@Mock
	private ReorderRulesRepo reorderRulesRepository;
	
	@Mock
	private PartRepo partRepository;
	
	@Mock
	private DemandRepo demandRepository;
	
	@Mock
	private PlantReorderDetails plantReorderDetailsRepository;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	ReorderRules reorderrules1 = new ReorderRules(1,1,10,20,100);
	ReorderRules reorderrules2 = new ReorderRules(2,2,10,20,100);

	@Test
	public void findByPartIdPositiveTest() {
		List<ReorderRules> reorderRulesactual= new ArrayList<>();
		reorderRulesactual.add(reorderrules1);
		Mockito.when(reorderRulesRepository.findByPartPartId(1)).thenReturn(reorderRulesactual);
		ReorderRules reorderRulesexpected=plantService.findById(1);
		assertEquals(reorderRulesexpected,reorderRulesactual.get(0));
	}
	
	@Test
	public void findByPartIdNegativeTest() {
		List<ReorderRules> reorderRulesactual= new ArrayList<>();
		reorderRulesactual.add(reorderrules1);
		reorderRulesactual.add(reorderrules2);
		Mockito.when(reorderRulesRepository.findByPartPartId(1)).thenReturn(reorderRulesactual);
		ReorderRules reorderRulesexpected=plantService.findById(1);
		assertNotEquals(reorderRulesexpected,reorderRulesactual);
	}
	
//	@Test
//	public void viewStockInHandPositiveTest() {
//		Part partActual=new Part(1,"Diode","20cm",10);
//		Mockito.when(partRepository.findByPartId(1)).thenReturn(partActual);
//		PartPojo partExpected=plantService.viewStockInHand(1);
//		assertEquals(partExpected,partActual);
//	}
//	
//	@Test
//	public void viewStockInHandNegativeTest() {
//		Part partActual=new Part(1,"Diode","20cm",10);
//		Mockito.when(partRepository.findByPartId(1)).thenReturn(partActual);
//		PartPojo partExpected=plantService.viewStockInHand(0);
//		assertNotEquals(partExpected,partActual);
//	}
//	
	
	@Test
	public void saveTest() {
		ReorderRules reorderRules=new ReorderRules(1,1,10,20,100);
		reorderRulesRepository.save(reorderRules);
		assertThat(reorderRules.getDemandId()).isGreaterThan(0);
	}
	
	@Test
	public void saveNegativeTest() {
		ReorderRules reorderRules=new ReorderRules();
		reorderRulesRepository.save(reorderRules);
		assertThat(reorderRules.getDemandId()).isEqualTo(null);
	}


}
