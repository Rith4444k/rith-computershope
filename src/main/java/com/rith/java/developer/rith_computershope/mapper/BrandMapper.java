package com.rith.java.developer.rith_computershope.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.rith.java.developer.rith_computershope.dto.BrandDTO;
import com.rith.java.developer.rith_computershope.entity.Brand;

@Mapper 
public interface BrandMapper {
	BrandMapper INSTANCE=Mappers.getMapper(BrandMapper.class);
	Brand toBrand(BrandDTO dto);
	BrandDTO toBrandDTO(Brand entity);
}
