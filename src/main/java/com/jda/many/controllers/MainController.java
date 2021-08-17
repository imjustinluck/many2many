package com.jda.many.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jda.many.models.Category;
import com.jda.many.models.Product;
import com.jda.many.services.MainService;

@Controller
public class MainController {

	@Autowired
	private MainService service;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
//	PRODUCT ROUTES
//	CREATE PRODUCT
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute Product product) {
		return "product.jsp";
	}
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "product.jsp";
		}
		else {
			service.createProduct(product);
			return "redirect:/";			
		}
	}
//	ADD CAT TO PRODUCT
	@GetMapping("/products/{id}")
	public String addToProduct(@PathVariable("id") Long id, Model model) {
		Product product = service.oneProduct(id);
		if(product == null) {
			return "redirect:/";
		}
		else {
			model.addAttribute(product);
			List<Category> categories = service.categoriesExempt(product);
			model.addAttribute("categories", categories);
			return "addToProd.jsp";			
		}		
	}
	@PostMapping("/products/{id}")
	public String submitToProduct(@PathVariable("id") Long id,
			@RequestParam("categoryId") Long categoryId, Model model) {
		
		Category category = service.oneCategory(categoryId);
		Product product = service.oneProduct(id);
		
		product.getCategories().add(category);
		service.updateProduct(product);
		
		return "redirect:/products/" + id;
	}

//	CATEGORY ROUTES
//	CREATE CATEGORY
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute Category category) {
		return "category.jsp";
	}
	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "category.jsp";
		}
		else {
			service.createCategory(category);
			return "redirect:/";			
		}
	}
//	ADD PRODUCT TO CAT
	@GetMapping("/categories/{id}")
	public String addToCategory(@PathVariable("id") Long id, Model model) {
		Category category = service.oneCategory(id);
		if(category == null) {
			return "redirect:/";
		}
		else {
			model.addAttribute(category);
			List<Product> products = service.productsExempt(category);
			model.addAttribute("products", products);
			return "addToCat.jsp";			
		}		
	}
//	@PostMapping("/products/{id}")
//	public String submitToProduct(@PathVariable("id") Long id,
//			@RequestParam("categoryId") Long categoryId, Model model) {
//		
//		Category category = service.oneCategory(categoryId);
//		Product product = service.oneProduct(id);
//		
//		product.getCategories().add(category);
//		service.updateProduct(product);
//		
//		return "redirect:/products/" + id;
//	}
}