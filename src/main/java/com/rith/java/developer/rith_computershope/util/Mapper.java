package com.rith.java.developer.rith_computershope.util;

import com.rith.java.developer.rith_computershope.dto.BrandDTO;
import com.rith.java.developer.rith_computershope.entity.Brand;

public class Mapper {
	public static Brand toEntity( BrandDTO dto) {
		Brand brand =new Brand();
		brand.setId(dto.getId());//if we don't want to return id ,just mark don't use this line
		brand.setName(dto.getName());
		return brand;
	}
}
