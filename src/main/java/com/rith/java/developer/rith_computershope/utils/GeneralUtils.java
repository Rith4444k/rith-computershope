package com.rith.java.developer.rith_computershope.utils;

import java.util.List;

public class GeneralUtils {
	// Example for understanding concept
	//convert list of string ot list of integer
	//["Tra","Mora","Seyha","Rith"]
	// => [3,4,5,4]
	
	public static List<Integer> toIntegerLish(List<String>list){
		return list .stream()
				.map(s->s.length())
				.toList();
		
	}
	
	public static List<Integer> getEvenNumber(List<Integer> list){
		return list.stream()
				   .filter(x->x%2==0)
				   .toList();
	}
}
