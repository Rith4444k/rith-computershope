package com.rith.java.developer.rith_computershope.service;

import java.util.List;

import com.rith.java.developer.rith_computershope.entity.Brand;


public interface BrandService  {
	Brand create(Brand brand);
	Brand getById(Integer id);
	Brand update(Integer id,Brand brandUpdated);
	List<Brand> getBrands();
	List<Brand> getBrands(String name);
	void deleteById(Integer Id);
}
