package com.zara.interview.application;

import com.zara.interview.application.infraestructure.input.cmd.GridProductCmdController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZaraInterviewApplication implements CommandLineRunner {

	private final GridProductCmdController productVisibilityController;

	@Autowired
	public ZaraInterviewApplication(GridProductCmdController productVisibilityController) {
		this.productVisibilityController = productVisibilityController;
	}

	@Override
	public void run(String... args) throws Exception {
		productVisibilityController.getProducts();
	}

	public static void main(String[] args) {
		SpringApplication.run(ZaraInterviewApplication.class, args);
	}
}