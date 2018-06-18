package com.sapient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author RAVINDRA.SINGH
 *  RA20004613
 *
 */
@SpringBootApplication
public class SapientFeeCalculatorApplication {

	private static final Logger logger = LoggerFactory.getLogger(SapientFeeCalculatorApplication.class);
	public static void main(String[] args) {
		logger.info("----------------------------------- SapientFeeCalculatorApplication Class Start -----------------------------");
		SpringApplication.run(SapientFeeCalculatorApplication.class, args);
		
	}
}
