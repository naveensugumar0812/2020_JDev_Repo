/**
 * 
 */
package com.bank.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bank.application.service.NumberConverterService;

/**
 * @author NaveenSugumar
 *
 */

@RestController
public class ConvertWordController {
	
	@Autowired
	private NumberConverterService converterService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConvertWordController.class);

	/**
	 * @param args
	 */
	/*
	 * public static void main(String[] args) { Scanner scanner = new
	 * Scanner(System.in);
	 * System.out.println("Please enter your number to be converted : "); int number
	 * = scanner.nextInt(); scanner.close();
	 * 
	 * System.out.println(" The Number Entered As Input : " + number);
	 * 
	 * 
	 * 
	 * }
	 */
	@GetMapping(value = "/converter/{number}", produces = "application/json")
    public String convertNumToWord(@PathVariable int number) {
		String inWords="";
		LOGGER.info("Entered number :: "+number);
		try {
		inWords=converterService.convertNumToWord(number);
		} catch(NumberFormatException nfe) {
			inWords=nfe.getMessage();
		} catch(Exception exception) {
			inWords=exception.getMessage();
		}

        return inWords;
    }

}
