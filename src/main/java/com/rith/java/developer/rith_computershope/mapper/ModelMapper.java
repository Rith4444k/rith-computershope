package com.rith.java.developer.rith_computershope.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.rith.java.developer.rith_computershope.dto.ModelDTO;
import com.rith.java.developer.rith_computershope.entity.Brand;
import com.rith.java.developer.rith_computershope.entity.Model;

@Mapper
public interface ModelMapper {

	ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);
	
	@Mapping(target = "brand", source = "brandId")
	Model toModel(ModelDTO modelDTO);
	default Brand toBrand(Integer brandId) {
		Brand brand =new Brand();
		brand.setId(brandId);
		return brand;
	}
    @Mapping(target = "brandId",source = "brand.id")
	ModelDTO toModelDTO(Model model);
	
}
