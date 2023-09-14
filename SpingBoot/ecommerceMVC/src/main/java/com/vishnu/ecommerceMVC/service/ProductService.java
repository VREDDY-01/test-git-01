package com.vishnu.ecommerceMVC.service;

import com.vishnu.ecommerceMVC.entities.Category;
import com.vishnu.ecommerceMVC.entities.Product;
import com.vishnu.ecommerceMVC.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProductService {
	@Autowired
	ProductRepo productRepo;

	public String addProduct(Product myProduct) {
		productRepo.getProductList().put(myProduct.getProductId(),myProduct);
		return "product added Successfully";
	}

	public Map<Integer, Product> getAllProducts() {
		return productRepo.getProductList();
	}

	public String updateProduct(Product updatedProduct, Integer id) {
		for(Integer keyId : getAllProducts().keySet())
		{
			if (keyId.equals(id)){
				Product product = getAllProducts().get(id);
				product.setProductName(updatedProduct.getProductName());
				product.setProductCategory(updatedProduct.getProductCategory());
				product.setProductPrice(updatedProduct.getProductPrice());
			}
		}
		return "updated product with id: "+id;
	}

	public String deleteProduct(Integer id) {
		getAllProducts().remove(id);
		return "deleted product with id: "+id;
	}

	public String addProducts(Product[] productList) {
		for (Product product:productList) {
			productRepo.getProductList().putIfAbsent(product.getProductId(),product);
		}
		return "added Succefully";
	}

	public List<Product> getProductsByCategory(Category category) {
		return productRepo.getProductList().values()
				.stream()
				.filter((product -> product.getProductCategory().equals(category)))
				.collect(Collectors.toList());
	}

	public Product getProductId(Integer id) {
		return productRepo.getProductList().get(id);
	}
}
