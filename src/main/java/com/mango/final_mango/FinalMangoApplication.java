package com.mango.final_mango;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class FinalMangoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalMangoApplication.class, args);
	}

}
