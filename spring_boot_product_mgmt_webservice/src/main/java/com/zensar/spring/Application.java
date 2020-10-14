package com.zensar.spring;

import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
@EnableSwagger2
@EnableCaching
public class Application extends SpringBootServletInitializer /* implements CommandLineRunner */
{
	// @Autowired
	// private ProductController controller;
	public static void main(String[] args) {
		// SpringApplication.run(Application.class, args);

		new SpringApplicationBuilder(Application.class)
		.properties("spring.config.name:myApplication")
		.properties("server.port:8085")
		.build().run(args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return super.configure(builder);
	}

	/*
	 * @Override public void run(String... args) throws Exception { Product
	 * product=new Product(); product.setProductId(101);
	 * product.setProductName("Fan"); product.setProductCost(200);
	 * controller.insertProduct(product);
	 * 
	 * Product product1=new Product(); product1.setProductId(102);
	 * product1.setProductName("KeyBoard"); product1.setProductCost(1200);
	 * controller.insertProduct(product1); }
	 */
}
