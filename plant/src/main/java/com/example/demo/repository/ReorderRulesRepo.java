package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.ReorderRules;

public interface ReorderRulesRepo extends JpaRepository<ReorderRules, Integer>{
	 List<ReorderRules> findByPartPartId(Integer partId);
}
