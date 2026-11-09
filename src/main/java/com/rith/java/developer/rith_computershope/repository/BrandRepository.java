package com.rith.java.developer.rith_computershope.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.rith.java.developer.rith_computershope.entity.Brand;
import com.rith.java.developer.rith_computershope.specifition.BrandSpec;


public interface BrandRepository extends JpaRepository<Brand, Integer>, JpaSpecificationExecutor<Brand> {

	//List<Brand>findBynameIgnoreCase(String name);
	//List<Brand>findByNameContaining(String name);
}

