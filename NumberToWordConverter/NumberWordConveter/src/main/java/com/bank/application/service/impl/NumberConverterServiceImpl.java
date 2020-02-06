/**
 * 
 */
package com.bank.application.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bank.application.controller.ConvertWordController;
import com.bank.application.service.NumberConverterService;
import com.bank.application.util.ErrorMessageConstants;
import com.bank.application.util.ServiceConstants;
import com.bank.application.util.WordConvertorForOnes;
import com.bank.application.util.WordConvertorForTens;

/**
 * @author NaveenSugumar
 *
 */

@Repository
public class NumberConverterServiceImpl implements NumberConverterService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NumberConverterServiceImpl.class);

	@Override
	public String convertNumToWord(int number) throws NumberFormatException  {
		StringBuilder wordConvertorString = new StringBuilder();
		
		checkMinMaxNumber(number);
		
		wordConvertor(((number / 100000) % 100), ServiceConstants.LAKH,wordConvertorString);
		wordConvertor(((number / 1000) % 100), ServiceConstants.THOUSAND,wordConvertorString);
		wordConvertor(((number / 100) % 10), ServiceConstants.HUNDRED,wordConvertorString);

		if((number > 100) && ((number % 100) > 0)) {
			wordConvertorString.append(ServiceConstants.EMPTY + ServiceConstants.AND +ServiceConstants.EMPTY);
		}
		
		wordConvertor((number % 100), ServiceConstants.EMPTY,wordConvertorString);

		return wordConvertorString.toString();
	}

	private void checkMinMaxNumber(int number) {
		if (number <= 0) {
			throw new NumberFormatException(ErrorMessageConstants.INVALID_DATA);
		} else if(number > 999999) {
			throw new NumberFormatException(ErrorMessageConstants.EXCEEDS_RANGE);
		}
	}
	
	private void wordConvertor(int number, String numberCount,StringBuilder wordConvertorString) {
		LOGGER.info("wordConvertor:: Number: "+number);
		if(number > 19) {
			int tensIndex = number/10;
			int onesIndex = number%10;

			if(tensIndex == 0 || tensIndex == 1) {
				wordConvertorString.append(ServiceConstants.EMPTY);
			} else {
				wordConvertorString.append(WordConvertorForTens.getType(String.valueOf(tensIndex)));
				wordConvertorString.append(ServiceConstants.EMPTY);
			}

			if(onesIndex == 0) {
				wordConvertorString.append(ServiceConstants.EMPTY);
			} else {
				wordConvertorString.append(WordConvertorForOnes.getType(String.valueOf(onesIndex)));
			}
		} else {
			if(number > 0) {
				wordConvertorString.append(WordConvertorForOnes.getType(String.valueOf(number)));
			} else {
				wordConvertorString.append(ServiceConstants.EMPTY);
			}

		}
		
		if(number > 0) {
			wordConvertorString.append(ServiceConstants.EMPTY + numberCount + ServiceConstants.EMPTY);
		}
	}
}
