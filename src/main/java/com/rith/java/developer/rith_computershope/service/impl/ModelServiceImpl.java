package com.rith.java.developer.rith_computershope.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rith.java.developer.rith_computershope.entity.Model;
import com.rith.java.developer.rith_computershope.repository.ModelRepository;
import com.rith.java.developer.rith_computershope.service.BrandService;
import com.rith.java.developer.rith_computershope.service.ModelService;
@Service // for spring we use component in spring boot we also can use component too
public class ModelServiceImpl implements ModelService {
	@Autowired
	private ModelRepository modelRepository;
	@Autowired  // We also can use AllArgsConstructor Instead of Autowired
	private BrandService brandService;
	@Override
	public Model save(Model model) {
		
		return modelRepository.save(model);
		
	}

}
