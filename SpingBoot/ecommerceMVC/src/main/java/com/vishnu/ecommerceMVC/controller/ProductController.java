package com.vishnu.ecommerceMVC.controller;

import com.vishnu.ecommerceMVC.entities.Category;
import com.vishnu.ecommerceMVC.entities.Product;
import com.vishnu.ecommerceMVC.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;

	@PostMapping("product")
	public String postProduct(@RequestBody Product myProduct){
		return productService.addProduct(myProduct);
	}
	@PostMapping("products")
	public String postProducts(@RequestBody Product[] productList){
		return productService.addProducts(productList);
	}

	@GetMapping("products")
	public Map<Integer,Product> getProducts(){
		return productService.getAllProducts();
	}
	@GetMapping("products/product/{id}")
	public Product getProductWithId(@PathVariable Integer id){
		return productService.getProductId(id);
	}
	@GetMapping("products/{category}")
	public List<Product> getProductWithCategory(@PathVariable Category category){
		return productService.getProductsByCategory(category);
	}

	@PutMapping("products/{id}")
	public String updateProduct(@RequestBody Product updatedProduct,@PathVariable Integer id){
		return productService.updateProduct(updatedProduct,id);
	}

	@DeleteMapping("products/{id}")
	public String deleteProduct(@PathVariable Integer id){
		return productService.deleteProduct(id);
	}
}
