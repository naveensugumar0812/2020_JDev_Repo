package com.bank.application.util;

import java.util.HashMap;
import java.util.Map;


/**
 * Enum for Ten's Digit location position 
 * @author NaveenSugumar
 *
 */
public enum WordConvertorForTens {

	TWENTY,THIRTY,FORTY,FIFTY,SIXTY,SEVENTY,EIGHTY,NINETY;
	
	
	private static final Map<String, WordConvertorForTens> LOOKUPFORTEN = new HashMap<String, WordConvertorForTens>();
	static int index =2;
	
	static {
		
		for (WordConvertorForTens type : WordConvertorForTens.values()) {
			LOOKUPFORTEN.put(String.valueOf(index++), type);
		}
	}
	
	
	/**
	 * Method to get Enum WordConvertor Type for given key
	 * @param key
	 * @return
	 */
	public static WordConvertorForTens getType(String key) {
		return LOOKUPFORTEN.get(key);
	}
}
