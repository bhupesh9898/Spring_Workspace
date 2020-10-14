package com.zensar.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zensar.model.Product;
import com.zensar.spring.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@RequestMapping("/home")
	public String home() {
		return "index";
	}

	@RequestMapping("/insert")
	public String insert(@ModelAttribute("product") Product product,ModelMap map) {
		map.addAttribute("productNames", getNames());
		return "insertProduct";
	}

	@RequestMapping("/insertProduct")
	public String insertProduct(@Valid @ModelAttribute Product product, BindingResult error, Model model) {

		if (error.hasErrors() == true) {

			System.out.println("Error caught" + error);
			return "insertProduct";
		}

		int result = service.insertProduct(product);
		if (result >= 0) {

			List<Product> allProducts = service.getAllProducts();
			List<String> productNames = new ArrayList<String>();
			for (Product product1 : allProducts) {
				productNames.add(product1.getProductName());
			}
			model.addAttribute("productNames", productNames);
			return "insert-success";

		} else
			return "insert-fail";
	}

	@RequestMapping("/getAll")
	public String getAllProduct(Model model) {
		List<Product> allProducts = service.getAllProducts();
		List<String> productNames = new ArrayList<String>();
		for (Product product1 : allProducts) {
			productNames.add(product1.getProductName());
		}
		model.addAttribute("productNames", productNames);

		return "displayAllProduct";
	}

	@RequestMapping("/getOne")
	public String getOne() {
		return "getOne";
	}

	@RequestMapping("/displayOne")
	public String getParticularProduct(@RequestParam("id") int id, Model model) {

		Product product = service.getParticularProduct(id);
		model.addAttribute("product", product);
		return "displayOne";
	}

	@RequestMapping("/displayOneByName{productName}")
	public String getParticularProductFromTable(@PathVariable("productName") String productName, Model model,Model model2) {

		Product product = service.getParticularProductByName(productName);
		model.addAttribute("product", product);
	

		List<Product> allProducts = service.getAllProducts();
		List<String> productNames = new ArrayList<String>();
		for (Product product1 : allProducts) {
			productNames.add(product1.getProductName());
		}
		model2.addAttribute("productNames", productNames);
		return "displayOneByName";
	}

	@RequestMapping("/delete")
	public String delete() {
		return "delete";
	}

	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("id") int id, Model model) {
		System.out.println("\n\n\nInside Delete1...!!!!");
		service.deleteProduct(id);
		return "product-deleted";
	}

	@RequestMapping("/update")
	public String update(@ModelAttribute("product") Product product) {
		return "update";
	}
	
	@RequestMapping(value="/productOps", params="insert",method = RequestMethod.POST)
	public String insertProduct1(@Valid @ModelAttribute Product product, BindingResult error, ModelMap map) {

		if (error.hasErrors() == true) {

			System.out.println("Error caught" + error);
			return "insertProduct";
		}

		int result = service.insertProduct(product);
		if (result >= 0) {
			String msg="Product Inserted Successfully..!!!";
			map.addAttribute("productNames", getNames());
			map.addAttribute("msg1", msg);
			return "update-success";

		} else
			return "insert-fail";
	}
	
	public List<String> getNames(){
		List<Product> allProducts = service.getAllProducts();
		List<String> productNames = new ArrayList<String>();
		for (Product product : allProducts) {
			productNames.add(product.getProductName());
		}
		return productNames;
	}
	@RequestMapping(value="/productOps", params="update",method = RequestMethod.POST)
	public String updateProduct1(@Valid @ModelAttribute Product product, BindingResult result,ModelMap map) {
		if (result.hasErrors()) {
			System.out.println("Error in update ");
			return "updateProduct";
		}
		System.out.println("\n\n\nInside Update...!!!!");
		Product product2 = service.updateProduct(product);
		map.addAttribute("product", product2);	
		map.addAttribute("productNames", getNames());
		
		
		String msg="Product Updated Successfully..!!!!";
		map.addAttribute("msg1", msg);
		return "update-success";
	}
	
	@RequestMapping(value="/productOps", params="delete",method = RequestMethod.POST)
	public String deleteProduct1(@Valid @ModelAttribute Product product, BindingResult result, ModelMap map) {
		System.out.println("\n\n\nInside delete...!!!!");
		service.deleteProduct(product.getProductId());
	
		map.addAttribute("productNames", getNames());
		String msg="Product Deleted Successfully..!!!!";
		map.addAttribute("msg1", msg);
		return "update-success";
	}
	
	@ModelAttribute
	public void addCommonMessage(ModelMap map) {
		String msg = "Product Management Application";
		String msg2=" Product Details ";
		map.addAttribute("msg", msg);
		map.addAttribute("msg2", msg2);
	}
}
