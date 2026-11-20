package com.rith.java.developer.rith_computershope.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rith.java.developer.rith_computershope.entity.Brand;
import com.rith.java.developer.rith_computershope.exception.ResourceNotFoundException;
import com.rith.java.developer.rith_computershope.repository.BrandRepository;
import com.rith.java.developer.rith_computershope.service.impl.BrandServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BrandServiceTestVersion2 {
	@Mock 
	BrandRepository brandRepository;
	
	BrandServiceImpl brandServce;
	@BeforeEach
	public void setUp() {
	 brandServce  =new BrandServiceImpl(brandRepository);
	}
	@Test
	public void createBrandTest() {
		//Given
			Brand brand =new Brand();
			brand.setName("Asus");
			brand.setId(1);
		//When
			brandServce.create(brand);
		//Then
			verify(brandRepository, times(1)).save(brand);
	}
	@Test 
	public void getByIdTest() {//Step Optional
		//Given
			Brand brand =new Brand();
			brand.setName("Asus");
			brand.setId(1);
		//When
			when(brandRepository.findById(1)).thenReturn(Optional.of(brand));
			Brand brandReturn = brandServce.getById(1);
		//Then
			assertEquals(1, brandReturn.getId());
			assertEquals("Asus", brandReturn.getName());
			
	}
	@Test
	public void getByIdThrow() {//Step throw Exception
		//Given
			
		//When
			when(brandRepository.findById(2)).thenReturn(Optional.empty());
			assertThatThrownBy(() -> brandServce.getById(2))
				.isInstanceOf(ResourceNotFoundException.class)
				.hasMessage("Brand With id =2 not found");
		//Then
	}
}
