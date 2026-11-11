package com.rith.java.developer.rith_computershope.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import com.rith.java.developer.rith_computershope.entity.Brand;
// Need to mark this key for test  not mark @Service 
@DataJpaTest
public class BrandRepositoryTest {
	// Test when we create function in BrandRepository only
	@Autowired
	private BrandRepository brandRepository;
	@Test
	public void testFindBynameLike() {
		//Given 
		Brand brand =new Brand();
		brand.setName("Assus");
		brandRepository.save(brand);
		//When 
		List<Brand> brands = brandRepository.findBynameLike("%A%");
		//Then
		assertEquals(1, brands.size());
		assertEquals("Assus", brands.get(0).getName());
		assertEquals(1, brands.get(0).getId());
	}
}
