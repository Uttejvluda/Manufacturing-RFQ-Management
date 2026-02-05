package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.PlantReorderDetails;

public interface PlantReorderRepo extends JpaRepository<PlantReorderDetails, Integer>{
	List<PlantReorderDetails> findByPartPartId(int partid);	
}
