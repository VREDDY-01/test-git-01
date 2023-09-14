package com.vishnu.ecommerceMVC.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private Integer productId;
	private String productName;
	private Integer productPrice;
	private Category productCategory;
}
