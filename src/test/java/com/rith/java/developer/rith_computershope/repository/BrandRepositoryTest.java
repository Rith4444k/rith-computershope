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
	@Test
	public void testFindByNameContaining() {
		//Given 
		Brand brand1 =new Brand();
		brand1.setName("assus");
		Brand brand2 = new Brand();
		brand2.setName("Samsung");
		brandRepository.save(brand1);
		brandRepository.save(brand2);
		//When 
		List<Brand> brandtest2 = brandRepository.findByNameContaining("A");
		//Then
		assertEquals(2, brandtest2.size());
		assertEquals("assus", brandtest2.get(0).getName());
		assertEquals("Samsung", brandtest2.get(1).getName());
		assertEquals(1, brandtest2.get(0).getId());
	}
}
