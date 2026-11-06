package com.rith.java.developer.rith_computershope.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rith.java.developer.rith_computershope.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
	//List<Brand>findBynameIgnoreCase(String name); 
	List<Brand>findByNameContaining(String name);
}

