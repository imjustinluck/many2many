package com.jda.many.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jda.many.models.Category;
import com.jda.many.models.Product;
import com.jda.many.repositories.CategoryRepository;
import com.jda.many.repositories.ProductRepository;


@Service
public class MainService {
		
		@Autowired
		private ProductRepository productRepo;
		
		@Autowired
		private CategoryRepository categoryRepo;
		
//		PRODUCTS:
//		CREATE
		public Product createProduct(Product product) {
			return productRepo.save(product);
		}
//		READ ALL PRODUCT
		public List<Product> allProducts() {
			return productRepo.findAll();
		}
//		READ ALL EXCEPT
		public List<Product> productsExempt(Category category){
			return productRepo.findByCategoriesNotContains(category);
		}
//		READ ONE PRODUCT
		public Product oneProduct(Long id) {
			Optional<Product> product = productRepo.findById(id);
			if(!product.isEmpty()) {
				return product.get();
			}
			else {
				return null;
			}
		}
//		UPDATE PRODUCT
		public Product updateProduct(Product product) {
			return productRepo.save(product);
		}
		
//		CATEGORIES:
//		CREATE
		public Category createCategory(Category category) {
			return categoryRepo.save(category);
		}
//		READ ALL
		public List<Category> allCategories() {
			return categoryRepo.findAll();
		}
//		READ ALL EXCEPT
		public List<Category> categoriesExempt(Product product){
			return categoryRepo.findByProductsNotContains(product);
		}
//		READ ONE
		public Category oneCategory(Long id) {
			Optional<Category> category = categoryRepo.findById(id);
			if(!category.isEmpty()) {
				return category.get();
			}
			else {
				return null;
			}
		}
//		UPDATE
		public Category updateCategory(Category category) {
			return categoryRepo.save(category);
		}
}
