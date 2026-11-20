package com.rith.java.developer.rith_computershope.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rith.java.developer.rith_computershope.entity.Brand;
import com.rith.java.developer.rith_computershope.repository.BrandRepository;
import com.rith.java.developer.rith_computershope.service.impl.BrandServiceImpl;

@ExtendWith(MockitoExtension.class)// Here is importance cuz we use mock , if not it's error null pointer like non Autowired
public class BrandServiceTestVersion1 {
	
	@Mock // We have already know that All the function in BransRepository it's working normally so we just mark @Mock 
	BrandRepository brandRepository;
	
	BrandServiceImpl brandService;
	
	@BeforeEach  // Here use for control compile run this function before run all these test case
	public void setUp() {
		
		brandService = new BrandServiceImpl(brandRepository);
	}
	@Test
	public void createTest() {
		//Given
			Brand brand =new Brand();
			brand.setName("Asus");
			brand.setId(1);
		//When
			/*when(brandRepository.save(any(Brand.class))).thenReturn(brand);//V1 Any Brand
			Brand brandReturn = brandService.create(new Brand());*/
			when(brandRepository.save(brand)).thenReturn(brand);//V2 Specific Brand
			Brand brandReturn = brandService.create(brand);
		//Then
			assertEquals(1, brand.getId());
			assertEquals("Asus", brand.getName()); 
		
	}
}
