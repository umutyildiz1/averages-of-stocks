package com.umutyildiz.averagesofstock;

import com.umutyildiz.averageofpurchased.*;
import com.umutyildiz.averageofpurchased.Main;
import javafx.application.Application;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AveragesofstockApplication {

	public static void main(String[] args) {
		SpringApplication.run(AveragesofstockApplication.class, args);
		Application.launch(Main.class);
	}

}
