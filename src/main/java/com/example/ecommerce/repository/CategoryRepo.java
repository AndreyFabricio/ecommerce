package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ecommerce.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
