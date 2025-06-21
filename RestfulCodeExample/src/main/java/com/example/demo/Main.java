package com.example.demo;

import com.example.demo.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		Product product = new Product("a123","milk","el mar3ay","liquid",50.5,20);
		Product product1 = new Product("c123","cheese","el mar3ay","lajaj",199.99,40);
		Product product2 = new Product("b123","dress","el mar3ay","clothes",800.0,50);
		Common.Products.put(product.getSerialNumber(),product);
		Common.Products.put(product1.getSerialNumber(),product1);
		Common.Products.put(product2.getSerialNumber(),product2);
		SpringApplication.run(Main.class, args);
	}

}

