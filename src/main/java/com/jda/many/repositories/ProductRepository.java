package com.jda.many.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jda.many.models.Category;
import com.jda.many.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findAll();
	
	List<Product> findByCategoriesNotContains(Category category);
	
}
