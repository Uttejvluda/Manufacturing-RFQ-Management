package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Part;

public interface PartRepo extends JpaRepository<Part, Integer> {
	public Part findByPartId(int partid);
}
