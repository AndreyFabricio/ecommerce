package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/create")
	public String createCategory(@RequestBody Category category) {
		categoryService.createCategory(category);
		return "sucess";
	}
	
	@GetMapping("/list")
	public List<Category> listCategory() {
		return categoryService.listCategory();
	}
	
}
