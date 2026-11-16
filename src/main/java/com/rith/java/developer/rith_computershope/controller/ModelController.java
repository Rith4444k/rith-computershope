package com.rith.java.developer.rith_computershope.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rith.java.developer.rith_computershope.dto.ModelDTO;
import com.rith.java.developer.rith_computershope.entity.Model;
import com.rith.java.developer.rith_computershope.mapper.ModelMapper;
import com.rith.java.developer.rith_computershope.service.ModelService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor// Can use instead of @Autowired
@RestController
@RequestMapping("/models")
public class ModelController {
	private final ModelService  modelService;
	private final ModelMapper modelMapperp;
	//@RequestMapping(method =RequestMethod.POST)
	@PostMapping
	public ResponseEntity<?> createModel(@RequestBody  ModelDTO modelDto){
		Model model = modelMapperp.toModel(modelDto);
			  model =modelService.save(model);
		return ResponseEntity.ok(ModelMapper.INSTANCE.toModelDTO(model));
	}
}
