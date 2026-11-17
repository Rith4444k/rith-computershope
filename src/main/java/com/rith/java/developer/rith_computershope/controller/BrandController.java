package com.rith.java.developer.rith_computershope.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rith.java.developer.rith_computershope.dto.BrandDTO;
import com.rith.java.developer.rith_computershope.dto.ModelDTO;
import com.rith.java.developer.rith_computershope.dto.PageDTO;
import com.rith.java.developer.rith_computershope.entity.Brand;
import com.rith.java.developer.rith_computershope.entity.Model;
import com.rith.java.developer.rith_computershope.mapper.BrandMapper;
import com.rith.java.developer.rith_computershope.mapper.ModelMapper;
import com.rith.java.developer.rith_computershope.service.BrandService;
import com.rith.java.developer.rith_computershope.service.ModelService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController 
@RequestMapping("brands")
@Tag(
	    name = "Brand Management",
	    description = "APIs for managing brand"
	)

public class BrandController {
	@Autowired
	private   BrandService brandservice;
	@Autowired
	private  ModelService modelService;
	
	
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
	/*@GetMapping//Version 1
	public ResponseEntity<?> getBrands() {
		return ResponseEntity.ok(brandservice.getBrands());
	}*/
	@GetMapping//Version 2 map to brandDTO use stream + map and collect+ JPA SCP
	public ResponseEntity<?> getBrands(@RequestParam Map<String , String> params ) {
		Page<Brand> page = brandservice.getBrands(params);
		PageDTO pageDTO=new PageDTO(page);
		//for test
		/*List<BrandDTO> list=brandservice.getBrands(params) 
				.stream()
				.map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
				.collect(Collectors.toList());*/
			return ResponseEntity.ok(pageDTO);
	}
	@DeleteMapping("/{id}") 
	public ResponseEntity<?> updateById(@PathVariable("id") Integer brandId  ) {
		brandservice.deleteById(brandId);
		String respone ="Brand deleted successfully";
		return ResponseEntity.ok(respone);
	} 
	
	@GetMapping("/{id}/models") 
	public ResponseEntity<?> getModelByBrand(@PathVariable("id") Integer brandId  ) {
		List<Model> models =modelService.getByBrandId(brandId);
		List<ModelDTO> modelDTO = models.stream()
										.map(model->ModelMapper.INSTANCE.toModelDTO(model))
										.toList();//Remember
		return ResponseEntity.ok(modelDTO);
	} 
	
}