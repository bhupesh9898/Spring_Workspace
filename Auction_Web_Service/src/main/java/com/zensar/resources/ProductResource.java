package com.zensar.resources;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zensar.model.Product;
import com.zensar.model.ProductCategory;
import com.zensar.model.User;
import com.zensar.service.ProductCategoryService;
import com.zensar.service.ProductService;
import com.zensar.util.CustomResponse;
import com.zensar.util.ImageOperationsUtility;

@RestController
@RequestMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class ProductResource {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductCategoryService productCategoryService;

	@PostMapping(value = "/sell/product")
	public CustomResponse sellProduct(@RequestBody Product product) {
		System.out.println("Http Session user.....:::::::::    " + User.session);

		if (User.session != null && User.session.getUserProfile().equalsIgnoreCase("Seller")) {
			product.setUser(User.session);
			product.setProductCategory(productCategoryService
					.getProductCategoryByName(product.getProductCategory().getProductCategoryName()));
			if (product.getImage() != null && product.getImage().length() > 10 && product != null) {

				System.out.println("Inside if sellProduct");
				productService.createProduct(product);
				return new CustomResponse(HttpStatus.CREATED.value(), "Product Registered For Bid");
			} else {

				System.out.println("Inside else sellProduct");

				ImageOperationsUtility.deleteImage(product.getImage());
				return new CustomResponse(HttpStatus.NOT_ACCEPTABLE.value(),
						"Please Upload Appropriate Image and Enter Appropriate Details ");
			}

		} else {
			return new CustomResponse(HttpStatus.UNAUTHORIZED.value(), "UnAuthorized Access");
		}

	}

	@GetMapping(value = "/categories")
	public CustomResponse getProductCategories() {
		boolean hasProductCategories = productCategoryService.getProductCategories().iterator().hasNext();
		if (hasProductCategories)
			return new CustomResponse(HttpStatus.OK.value(), "Here is the List of All Product Categories",
					productCategoryService.getProductCategories());
		else
			return new CustomResponse(HttpStatus.NOT_FOUND.value(), "No Product Categories Available",
					productCategoryService.getProductCategories());
	}

	@GetMapping(value = "/latest")
	public CustomResponse getLatestProducts() {
		boolean hasLatestProducts = productService.getLatestProducts().iterator().hasNext();
		if (hasLatestProducts)
			return new CustomResponse(HttpStatus.OK.value(), "Here is the List of All Latest Products",
					productService.getLatestProducts());
		else

			return new CustomResponse(HttpStatus.NOT_FOUND.value(), "No Latest Products Found",
					productService.getLatestProducts());
	}

	@GetMapping(value = "/details/{productId}")
	public CustomResponse getProductDetailsById(@PathVariable("productId") int productId) {
		Product product = productService.getProductDetailsById(productId);
		if (product != null)
			return new CustomResponse(HttpStatus.FOUND.value(), "Product Found with Details ", product);
		else
			return new CustomResponse(HttpStatus.NOT_FOUND.value(), "Product Not Found  ", product);
	}

	@GetMapping(value = "/live/products")
	public CustomResponse getLiveProducts() {
		boolean hasLiveProducts = productService.getLiveProducts().iterator().hasNext();
		if (hasLiveProducts)
			return new CustomResponse(HttpStatus.OK.value(), "Here is the List of Live Products ",
					productService.getLiveProducts());
		else
			return new CustomResponse(HttpStatus.NOT_FOUND.value(), "No Live Products ",
					productService.getLiveProducts());
	}

	@GetMapping(value = "/{priceLowerLimit}/{priceUpperLimit}")
	public CustomResponse getProductsByRange(@PathVariable("priceLowerLimit") int priceLowerLimit,
			@PathVariable("priceUpperLimit") int priceUpperLimit) {
		boolean hasProducts = productService.getProductsByRange(priceLowerLimit, priceUpperLimit).iterator().hasNext();
		if (hasProducts)
			return new CustomResponse(HttpStatus.OK.value(), "Here is the List of Products in Given Price Range ",
					productService.getLiveProducts());
		else
			return new CustomResponse(HttpStatus.NOT_FOUND.value(), "No Products Found in Given Price Range ",
					productService.getLiveProducts());

	}

	@GetMapping(value = "/category/{categoryId}")
	public CustomResponse getProductsByCategory(@PathVariable("categoryId") int categoryId) {
		boolean hasProducts = productService.getProductsByCategory(categoryId).iterator().hasNext();
		if (hasProducts)
			return new CustomResponse(HttpStatus.OK.value(),
					"Here is the List of Products By Category " + productService.getProductsByCategory(categoryId));
		else
			return new CustomResponse(HttpStatus.NOT_FOUND.value(),
					"Products Not Found By ID : " + productService.getProductsByCategory(categoryId));
	}

	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public CustomResponse uploadFile(@RequestParam("image") MultipartFile image)
			throws IOException {

		System.out.println("Inside Upload method.....!!!!!!");
		if (User.session != null && User.session.getUserProfile().equalsIgnoreCase("Seller")) {
			System.out.println("\n\n\n   inside if.....");
			String imageLocationPath = ImageOperationsUtility.uploadImage(image);
			if (imageLocationPath.equals("Extension of image is not correct")) {
				System.out.println("\n\n\n   inside 2nd if.....");
				return new CustomResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Extension of image is not correct");
			} else {
				System.out.println("\n\n\n   inside  1st else .....");
				return new CustomResponse(HttpStatus.OK.value(), imageLocationPath);
			}

		} else {
			System.out.println("\n\n\n   inside 2nd else.....");
			return new CustomResponse(HttpStatus.UNAUTHORIZED.value(), "UnAuthorized Access");
		}

	}

}
