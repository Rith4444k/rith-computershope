package com.rith.java.developer.rith_computershope.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rith.java.developer.rith_computershope.entity.Brand;
import com.rith.java.developer.rith_computershope.repository.BrandRepository;
import com.rith.java.developer.rith_computershope.service.BrandService;

@Service
public class BrandServceImpl implements BrandService{
	@Autowired
	private  BrandRepository brandrepository;

	
	@Override
	public Brand create(Brand brand) {
		return brandrepository.save(brand);
	}


	@Override
	public List<Brand> getBrands() {
		return brandrepository.findAll();
	}





}
 