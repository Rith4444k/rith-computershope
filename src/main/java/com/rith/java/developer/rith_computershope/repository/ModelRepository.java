package com.rith.java.developer.rith_computershope.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rith.java.developer.rith_computershope.entity.Model;

public interface ModelRepository extends JpaRepository<Model,Integer> {
	List<Model> findByBrandId(Integer brandId);
}
