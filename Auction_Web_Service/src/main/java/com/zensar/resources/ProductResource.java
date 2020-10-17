package com.zensar.resources;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.model.Product;
import com.zensar.model.ProductCategory;
import com.zensar.model.User;
import com.zensar.service.ProductCategoryService;
import com.zensar.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductResource {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductCategoryService productCategoryService;

	@PostMapping(value = "/sell/product")
	public ResponseEntity<String> sellProduct(@RequestBody Product product, HttpServletRequest request,String productCategoryName) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			product.setUser(user);
			product.setProductCategory(productCategoryService.getProductCategoryByName(productCategoryName));
			productService.createProduct(product);
			return new ResponseEntity<String>("Product Created", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("UnAuthorized Access", HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping(value = "/categories")
	public ResponseEntity<Iterable<ProductCategory>> getProductCategories() {
		boolean hasProductCategories = productCategoryService.getProductCategories().iterator().hasNext();
		if (hasProductCategories)
			return new ResponseEntity<Iterable<ProductCategory>>(productCategoryService.getProductCategories(),
					HttpStatus.OK);
		else
			return new ResponseEntity<Iterable<ProductCategory>>(productCategoryService.getProductCategories(),
					HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/latest")
	public ResponseEntity<Iterable<Product>> getLatestProducts() {
		boolean hasLatestProducts = productService.getLatestProducts().iterator().hasNext();
		if (hasLatestProducts)
			return new ResponseEntity<Iterable<Product>>(productService.getLatestProducts(), HttpStatus.OK);
		else
			return new ResponseEntity<Iterable<Product>>(productService.getLatestProducts(), HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/details/{productId}")
	public ResponseEntity<Product> getProductDetailsById(@PathVariable("productId") int productId) {
		Product product = productService.getProductDetailsById(productId);
		if (product != null)
			return new ResponseEntity<Product>(product, HttpStatus.FOUND);
		else
			return new ResponseEntity<Product>(product, HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/live/products")
	public ResponseEntity<Iterable<Product>> getLiveProducts() {
		boolean hasLiveProducts = productService.getLiveProducts().iterator().hasNext();
		if (hasLiveProducts)
			return new ResponseEntity<Iterable<Product>>(productService.getLiveProducts(), HttpStatus.OK);
		else
			return new ResponseEntity<Iterable<Product>>(productService.getLiveProducts(), HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/{priceLowerLimit}/{priceUpperLimit}")
	public ResponseEntity<Iterable<Product>> getProductsByRange(@PathVariable("priceLowerLimit") int priceLowerLimit,
			@PathVariable("priceUpperLimit") int priceUpperLimit) {
		boolean hasProducts = productService.getProductsByRange(priceLowerLimit, priceUpperLimit).iterator().hasNext();
		if (hasProducts)
			return new ResponseEntity<Iterable<Product>>(
					productService.getProductsByRange(priceLowerLimit, priceUpperLimit), HttpStatus.OK);
		else
			return new ResponseEntity<Iterable<Product>>(
					productService.getProductsByRange(priceLowerLimit, priceUpperLimit), HttpStatus.NOT_FOUND);

	}

	@GetMapping(value = "/category/{categoryId}")
	public ResponseEntity<Iterable<Product>> getProductsByCategory(@PathVariable("categoryId") int categoryId) {
		boolean hasProducts = productService.getProductsByCategory(categoryId).iterator().hasNext();
		if (hasProducts)
			return new ResponseEntity<Iterable<Product>>(productService.getProductsByCategory(categoryId),
					HttpStatus.OK);
		else
			return new ResponseEntity<Iterable<Product>>(productService.getProductsByCategory(categoryId),
					HttpStatus.NOT_FOUND);
	}

}
