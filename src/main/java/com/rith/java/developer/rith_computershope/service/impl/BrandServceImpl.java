package com.rith.java.developer.rith_computershope.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.rith.java.developer.rith_computershope.entity.Brand;
import com.rith.java.developer.rith_computershope.exception.ApiException;
import com.rith.java.developer.rith_computershope.exception.ResourceNotFoundException;
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

	// Version one  
	/*@Override
	public Brand getById(Integer id) {
		//return brandrepository.getById(id);
		Optional<Brand>brandOptional = brandrepository.findById(id);
		if(brandOptional.isPresent()) {
			return brandOptional.get();
		}else {
			//throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"Brand with id ="+id+"not found ");
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"Brand with id = %d not found ".formatted(id));
		}*/
	
	// Version two with package exception 
	@Override
	public Brand getById(Integer id) {
		//V1
		/*return brandrepository.findById(id) // use optional + supplier orElseThrow(as functional interface) 
			  .orElseThrow(()->new ApiException(HttpStatus.NOT_FOUND,"Brand with id= %d not found".formatted(id)));*/
		//v2 use ResourceNotfound
		return brandrepository.findById(id) 
				  .orElseThrow(()->new ResourceNotFoundException("Brand", id));
	}

	@Override
	public Brand update(Integer id, Brand brandUpdated) {
		Brand brand = getById(id);
		brand.setName(brandUpdated.getName());//Version1 TODO improve
		return brandrepository.save(brand);
	}

 





}
 