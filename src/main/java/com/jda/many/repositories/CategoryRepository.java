package com.jda.many.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jda.many.models.Category;
import com.jda.many.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    
	List<Category> findAll();
	
    List<Category> findByProductsNotContains(Product product);
	
}
