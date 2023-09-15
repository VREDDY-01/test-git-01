package com.vishnu.ecommerceMVC.controller;

import com.vishnu.ecommerceMVC.entities.Category;
import com.vishnu.ecommerceMVC.entities.Product;
import com.vishnu.ecommerceMVC.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Validated
public class ProductController {
	@Autowired
	ProductService productService;

	@PostMapping("product")
	public String postProduct(@RequestBody @Valid Product myProduct){
		return productService.addProduct(myProduct);
	}
	@PostMapping("products")
	public String postProducts(@RequestBody @Valid Product[] productList){
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

	@GetMapping("products/filter/lowerPrice/{lowerPrice}/higherPrice/{higherPrice}")
	List<Product> getProductsByPriceRange(@PathVariable @Min(10000) double lowerPrice,@PathVariable @Max(80000) double higherPrice)
	{
		return productService.getProductsByPrice(lowerPrice,higherPrice);
	}

	@GetMapping("products/filter/lowerPrice/{lowerPrice}/higherPrice/{higherPrice}/category")
	List<Product> getProductsByPriceRange(@PathVariable @Min(0) double lowerPrice, @PathVariable @Max(100000) double higherPrice, @RequestParam Category category)
	{
		return productService.getProductsByPriceAndCategory(lowerPrice,higherPrice,category);
	}
}
