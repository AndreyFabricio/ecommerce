package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.common.ApiResponse;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
	
	 @PostMapping("/create")
	    public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category) {
	        categoryService.createCategory(category);
	        return new ResponseEntity<ApiResponse>(new ApiResponse(
	        		true, "New category created"), HttpStatus.CREATED);
	    }
	
	@GetMapping("/list")
    public List<Category> listCategory() {
        return categoryService.listCategory();
    }
	
	@PostMapping("update/{categoryId}")
	public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryId") int categoryId, 
			@RequestBody Category category) {
		if(!categoryService.findById(categoryId)) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(
	        		false, "Category not found"), HttpStatus.NOT_FOUND);
		}
		categoryService.editCategory(categoryId, category);
		return new ResponseEntity<ApiResponse>(new ApiResponse(
        		true, "Category updated"), HttpStatus.OK);
	}
	
}
