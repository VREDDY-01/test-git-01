package com.vishnu.ecommerceMVC.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@NotNull
	private Integer productId;

	@NotBlank
	@Size(min = 5,max = 100)
	private String productName;

	@Pattern(regexp = "^product: .+")
	private String productDescription;

	private Integer productPrice;

	private Category productCategory;
}
