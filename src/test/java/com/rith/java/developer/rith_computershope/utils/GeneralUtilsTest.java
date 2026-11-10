package com.rith.java.developer.rith_computershope.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class GeneralUtilsTest {
	@Test
		public void testToIntegerList() {//Unit test have 3 step
			//Given 
			List<String>names=List.of("Tra","Mora","Seyha","Rith");
			//When
			List<Integer> list= GeneralUtils.toIntegerLish(names);
			//Then
			//[3,4,5,4]
			assertEquals(4, list.size());
			assertEquals(3, list.get(0));
			assertEquals(4, list.get(1));
			assertEquals(5, list.get(2));
			assertEquals(4, list.get(3));
		}
	@Test
		public void testgetEvenNumber() {
			//Given
			List<Integer>numbers=List.of(2,3,4,5,4);
			//When 
			List<Integer> evenNumbers = GeneralUtils.getEvenNumber(numbers);
			//Then
			assertEquals(3, evenNumbers.size());
			assertEquals(2, evenNumbers.get(0));
			assertEquals(4, evenNumbers.get(2));
		}
}
