package com.rith.java.developer.rith_computershope.service;

import java.util.Map;

import org.springframework.data.domain.Page;

import com.rith.java.developer.rith_computershope.entity.Brand;


public interface BrandService  {
	Brand create(Brand brand);
	Brand getById(Integer id);
	Brand update(Integer id,Brand brandUpdated);
	//List<Brand> getBrands(Map<String, String>params);
	Page<Brand> getBrands(Map<String, String>params);
	void deleteById(Integer Id);
	}
