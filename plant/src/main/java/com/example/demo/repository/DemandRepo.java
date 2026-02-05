package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Demand;

public interface DemandRepo extends JpaRepository<Demand, Integer> {
		List<Demand> findByPartPartId(int demandid);
}
