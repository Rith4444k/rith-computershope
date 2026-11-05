package com.rith.java.developer.rith_computershope.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rith.java.developer.rith_computershope.dto.BrandDTO;
import com.rith.java.developer.rith_computershope.entity.Brand;
import com.rith.java.developer.rith_computershope.mapper.BrandMapper;
import com.rith.java.developer.rith_computershope.service.BrandService;

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
		Brand brand=BrandMapper.INSTANCE.toBrand(branddto);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getBrandById(@PathVariable Integer id) {//if i don't want to use @PathVariable("id") i just change GetMapping("{id}") to Id like Integer Id
		Brand brand=brandservice.getById(id);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
	}
	
	@PutMapping("/{id}") 
	public ResponseEntity<?> updateById(@PathVariable("id") Integer brandId , @RequestBody BrandDTO brandDTO ) {
		Brand brand=BrandMapper.INSTANCE.toBrand(brandDTO);
		Brand brandUpdated=brandservice.update(brandId, brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brandUpdated));
	} 
}