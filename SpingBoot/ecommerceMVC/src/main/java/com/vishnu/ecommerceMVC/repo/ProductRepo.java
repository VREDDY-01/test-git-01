package com.vishnu.ecommerceMVC.repo;

import com.vishnu.ecommerceMVC.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ProductRepo {

	@Autowired
	private Map<Integer, Product> productList;

	public Map<Integer, Product> getProductList() {
		return productList;
	}
}
