package com.rith.java.developer.rith_computershope.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.rith.java.developer.rith_computershope.entity.Brand;
import com.rith.java.developer.rith_computershope.repository.BrandRepository;
import com.rith.java.developer.rith_computershope.service.BrandService;

@Service      //We need to mark @service here because this is a business logic or service layer
public class BrandServceImpl implements BrandService{
	@Autowired
	private  BrandRepository brandrepository;

	
	@Override
	public Brand create(Brand brand) {
		return brandrepository.save(brand);
	}


	@SuppressWarnings("deprecation")
	@Override
	public Brand getById(Integer id) {
		//return brandrepository.getById(id);
		Optional<Brand>brandOptional = brandrepository.findById(id);
		if(brandOptional.isPresent()) {
			return brandOptional.get();
		}else {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"Brand with id ="+id+"not found ");
		}
		 
	}







}
 