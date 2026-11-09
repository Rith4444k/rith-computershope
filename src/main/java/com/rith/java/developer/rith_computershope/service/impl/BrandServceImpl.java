package com.rith.java.developer.rith_computershope.service.impl;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rith.java.developer.rith_computershope.entity.Brand;
import com.rith.java.developer.rith_computershope.exception.ResourceNotFoundException;
import com.rith.java.developer.rith_computershope.repository.BrandRepository;
import com.rith.java.developer.rith_computershope.service.BrandService;
import com.rith.java.developer.rith_computershope.specifition.BrandFilter;
import com.rith.java.developer.rith_computershope.specifition.BrandSpec;
import com.rith.java.developer.rith_computershope.util.PageUtil;

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
		Optional<Brand>brandOptional = brandrepository.findById(id);
		if(brandOptional.isPresent()) {
			return brandOptional.get();
		}else {
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
/*
	@Override
	public List<Brand> getBrands() {		
		return brandrepository.findAll();
	}V1
*/
	
	@Override
	public void deleteById(Integer Id) {
		Brand brand=getById(Id);
	    brandrepository.deleteById(Id);
	}
   // Apply JPA V1
   /*
	@Override
	public List<Brand> getBrands(Map<String, String> params) {
		BrandFilter brandFilter=new BrandFilter();
		if(params.containsKey("name")) {
			String param=params.get("name");
			brandFilter.setName(param);
		}
		if(params.containsKey("id")) {
			String id=params.get("id");
			brandFilter.setId(Integer.parseInt(id));
		}
		BrandSpec brandSpec =new BrandSpec(brandFilter);
		
		
		return brandrepository.findAll(brandSpec);
	}
	*/
	@Override//Apply JPA V2+ Pageable
	public Page<Brand> getBrands(Map<String, String> params) {
		BrandFilter brandFilter=new BrandFilter();
		if(params.containsKey("name")) {
			String param=params.get("name");
			brandFilter.setName(param);
		}
		if(params.containsKey("id")) {
			String id=params.get("id");
			brandFilter.setId(Integer.parseInt(id));
		}
		// @TODO Add to function pageable
		int pageLimit=PageUtil.DEFAULT_PAGE_LIMIT;
		if(params.containsKey(PageUtil.PAGE_LIMIT)) {
			pageLimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
		}
		int pageNumber=PageUtil.DEFAULT_PAGE_NUMBER;
		if(params.containsKey(PageUtil.PAGE_NUMBER)) {
			pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
		}
		BrandSpec brandSpec =new BrandSpec(brandFilter);
		
		Pageable pageable =  PageUtil.getPageable(pageNumber ,pageLimit);
		Page<Brand> page = brandrepository.findAll(brandSpec, pageable);
		return page;
	}
};