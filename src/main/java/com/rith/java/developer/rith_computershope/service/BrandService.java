package com.rith.java.developer.rith_computershope.service;

import java.util.List;

import com.rith.java.developer.rith_computershope.entity.Brand;


public interface BrandService  {
	Brand create(Brand brand);
	List<Brand>  getBrands();
}
