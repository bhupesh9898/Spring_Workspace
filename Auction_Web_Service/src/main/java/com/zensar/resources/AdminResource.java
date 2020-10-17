package com.zensar.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.model.Mail;
import com.zensar.model.Product;
import com.zensar.model.ProductCategory;
import com.zensar.service.ProductCategoryService;
import com.zensar.service.ProductService;
import com.zensar.service.UserService;

@RestController
@RequestMapping(value = "/admin")
public class AdminResource {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductCategoryService productCategoryService;

	@Autowired
	private UserService userService;

	@PostMapping(value = "/send/mail")
	public ResponseEntity<String> sendMail(@RequestBody Mail mail) {
		userService.sendMail(mail);
		return new ResponseEntity<String>("Mail Sent",HttpStatus.OK);
	}

	@PatchMapping(value = "/update/product")
	public ResponseEntity<String> updateProduct(@RequestBody Product updatedProduct) {
		productService.updateProduct(updatedProduct);
		return new ResponseEntity<String>("Product Details Updated",HttpStatus.ACCEPTED);
	}
	
	@PatchMapping(value = "/add/product/category")
	public ResponseEntity<String> addProductCategory(@RequestBody ProductCategory productCategory){
		int result=productCategoryService.addProductCategory(productCategory);
		if(result==200)
			return new ResponseEntity<String>("Product Category Added",HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("Product Category Already Exists",HttpStatus.NOT_ACCEPTABLE);
	}
	


}
