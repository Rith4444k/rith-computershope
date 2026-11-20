package com.rith.java.developer.rith_computershope.service;


import java.util.List;

import com.rith.java.developer.rith_computershope.entity.Model;
public interface ModelService {
	Model save(Model model);
	List<Model>getByBrandId(Integer Id);
}
