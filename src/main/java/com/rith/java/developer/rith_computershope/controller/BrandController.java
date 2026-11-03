package com.rith.java.developer.rith_computershope.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rith.java.developer.rith_computershope.dto.BrandDTO;
import com.rith.java.developer.rith_computershope.entity.Brand;
import com.rith.java.developer.rith_computershope.service.BrandService;
import com.rith.java.developer.rith_computershope.util.Mapper;

@RestController 
@RequestMapping("brands")
public class BrandController {
	@Autowired
	private  BrandService brandservice;

	BrandController(BrandService brandservice) {
		this.brandservice = brandservice;
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createBrand(@RequestBody BrandDTO branddto) {
		Brand brand=Mapper.toEntity(branddto);
		brand=brandservice.create(brand);
		return ResponseEntity.ok(brand);
	}
	@GetMapping
	public ResponseEntity<List<Brand>> getBrands() {
		List<Brand> brands = brandservice.getBrands();
		return  ResponseEntity.ok(brands);
	}
}
