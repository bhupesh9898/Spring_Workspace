package com.zensar.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zensar.model.Product;
import com.zensar.spring.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute ("product") Product product) {
		return "insertProduct";
	}
	

	@RequestMapping("/insertProduct")
	public String insertProduct(@Valid @ModelAttribute Product product,BindingResult error,Model model ) {
		
		if(error.hasErrors()==true) {
			
			System.out.println("Error caught" +error);
			return "insertProduct";
		}
		
		int result=service.insertProduct(product);
		if(result>=0)
		{
			model.addAttribute("productId", result);
			return "insert-success";
			
		}
		else
			return "insert-fail";
	}

	
	@RequestMapping("/getAll")
	public String getAllProduct(Model model) {
		List<Product> allProducts = service.getAllProducts();
		model.addAttribute("products",	 allProducts);
		
		return "displayAllProduct";
	}
	
	@RequestMapping("/getOne")
	public String getOne() {
		return "getOne";
	}
	@RequestMapping("/displayOne")
	public String getParticularProduct(@RequestParam("id")int id,Model model) {
		
		Product product=service.getParticularProduct(id);
		model.addAttribute("product",product);
		return "displayOne";
	}
	
	@RequestMapping("/delete")
	public String delete() {
		return "delete";
	}
	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("id")int id,Model model) {
		
		service.deleteProduct(id);
		return "product-deleted";
	}
	
	
	@RequestMapping("/update")
	public String update(@ModelAttribute ("product") Product product) {
		return "update";
	}
	
	@RequestMapping("/updateProduct")
	public String updateProduct(@Valid @ModelAttribute Product product,BindingResult result,Model model) {
		if(result.hasErrors()) {
			System.out.println("Error in update ");
			return "updateProduct";
		}
		
		
		Product product2=service.updateProduct(product);
		model.addAttribute("product", product2);
		return "product-updated";
	}
	
	
	@ModelAttribute
	public void addCommonMessage(Model model) {
		String msg="Product Management Application";
		model.addAttribute("msg", msg);

	}
	
	/*
	@RequestMapping("/insert-success")
	public String insertSuccess(
			@RequestParam(name="textProductId",defaultValue = "100")int productId
			,@RequestParam(name="textProductName",defaultValue = "Test")String productName,
			@RequestParam(name="textProductCost",defaultValue = "1")int productCost,
			Model model) {
		
	
		
		Product product=new Product();
		product.setProductId(productId);
		product.setProductName(productName);
		product.setProductCost(productCost);
		
		model.addAttribute(product);
		System.out.println(product);
		
		return "insert-success";
	}
	
	*/
	
	
	

}
