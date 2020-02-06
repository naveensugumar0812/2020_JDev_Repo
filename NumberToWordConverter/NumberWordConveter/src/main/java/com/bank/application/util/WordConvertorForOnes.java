package com.bank.application.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum for One's Digit location position 
 * @author NaveenSugumar
 *
 */
public enum WordConvertorForOnes {

	
	ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,ELEVEN,TWELVE,THIRTEEN,
	FOURTEEN,FIFTEEN,SIXTEEN,SEVENTEEN,EIGHTEEN,NINETEEN;
	
	
	private static final Map<String, WordConvertorForOnes> LOOKUP = new HashMap<String, WordConvertorForOnes>();
	static int index =1;
	
	static {
		
		for (WordConvertorForOnes type : WordConvertorForOnes.values()) {
			LOOKUP.put(String.valueOf(index++), type);
		}
	}


	/**
	 * Method to get Enum WordConvertor Type for given key
	 * @param key
	 * @return
	 */
	public static WordConvertorForOnes getType(String key) {
		return LOOKUP.get(key);
	}
}
