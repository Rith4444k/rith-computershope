package com.rith.java.developer.rith_computershope.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.rith.java.developer.rith_computershope.dto.ModelDTO;
import com.rith.java.developer.rith_computershope.entity.Brand;
import com.rith.java.developer.rith_computershope.entity.Model;
import com.rith.java.developer.rith_computershope.service.BrandService;

@Mapper (componentModel ="Spring", uses = {BrandService.class})// Instead default function blow + Component Spring
public interface ModelMapper {

	ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);
	
	@Mapping(target = "brand", source = "brandId")
	Model toModel(ModelDTO modelDTO);
	/*
	default Brand toBrand(Integer brandId) {
		Brand brand =new Brand();
		brand.setId(brandId);
		return brand;
	*/
    @Mapping(target = "brandId",source = "brand.id")
	ModelDTO toModelDTO(Model model);
	
}
