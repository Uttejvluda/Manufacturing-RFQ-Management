package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Supplier_part;

public interface SuppilerPartRepo extends JpaRepository<Supplier_part, Integer> {

	public List<Supplier_part> findByPartname(String partName);
}
