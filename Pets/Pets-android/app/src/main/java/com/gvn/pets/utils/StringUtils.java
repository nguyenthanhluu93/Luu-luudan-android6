/*
 * 
 */
package com.gvn.pets.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

// TODO: Auto-generated Javadoc
/**
 * @author Created by Robert Hoang on 22 nov 2016
 * The Class StringUtils.
 */
public class StringUtils {
	
	/** The Constant NINE. */
	static final char NINE = (char) 0x39;
	
	/** The Constant ZERO. */
	static final char ZERO = (char) 0x30;
	
	/** The Constant CH_a. */
	static final char CH_a = 'a';
	
	/** The Constant CH_z. */
	static final char CH_z = 'z';
	
	/** The Constant CH_A. */
	static final char CH_A = 'A';
	
	/** The Constant CH_Z. */
	static final char CH_Z = 'Z';

	/**
	 * Append string.
	 *
	 * @param oldS the old s
	 * @param pos the pos
	 * @param s the s
	 * @return the string
	 */
	public static String appendString(String oldS, int pos, String s) {
		return (oldS.substring(0, pos) + s + oldS.substring(pos));
	}

	// To replace a character at a specified position
	/**
	 * Replace char at.
	 *
	 * @param s the s
	 * @param pos the pos
	 * @param c the c
	 * @return the string
	 */
	public static String replaceCharAt(String s, int pos, char c) {
		// return s.substring(0, pos) + c + s.substring(pos + 1);
		StringBuffer buf = new StringBuffer(s);
		buf.setCharAt(pos, c);
		return buf.toString();
	}

	// replace char with string
	/**
	 * Replace char.
	 *
	 * @param s the s
	 * @param a the a
	 * @param b the b
	 * @return the string
	 */
	public static String replaceChar(String s, char a, String b) {
		if (s == null)
			return null;

		StringBuffer newString = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == a) {
				newString.append(b);
			} else {
				newString.append(cur);
			}
		}
		return newString.toString();
	}

	// To remove a character
	/**
	 * Removes the char.
	 *
	 * @param s the s
	 * @param c the c
	 * @return the string
	 */
	public static String removeChar(String s, char c) {
		if (s == null)
			return null;

		StringBuffer newString = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur != c)
				newString.append(cur);
		}
		return newString.toString();
	}

	// To remove a character at a specified position
	/**
	 * Removes the char at.
	 *
	 * @param s the s
	 * @param pos the pos
	 * @return the string
	 */
	public static String removeCharAt(String s, int pos) {
		// return s.substring(0, pos) + s.substring(pos + 1);
		StringBuffer buf = new StringBuffer(s.length() - 1);
		buf.append(s.substring(0, pos)).append(s.substring(pos + 1));
		return buf.toString();
	}

	// .,*/abc --> abc
	/**
	 * Removes the special chars in front.
	 *
	 * @param s the s
	 * @return the string
	 */
	public static String removeSpecialCharsInFront(String s) {
		if (s == null)
			return null;
		String result = "";
		char currChar;
		for (int i = 0; i < s.length(); i++) {
			currChar = s.charAt(i);
			if ((currChar >= ZERO && currChar <= NINE)
					|| (currChar >= CH_a && currChar <= CH_z)
					|| (currChar >= CH_A && currChar <= CH_Z)) {
				result = s.substring(i);
				break;
			}
		}
		return result;
	}

	// "a.b-c" --> "abc"
	/**
	 * Removes the special chars in string.
	 *
	 * @param s the s
	 * @return the string
	 */
	public static String removeSpecialCharsInString(String s) {
		if (s == null)
			return null;
		StringBuffer buffer = new StringBuffer();
		char ch;
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if ((ch >= ZERO && ch <= NINE) || (ch >= CH_a && ch <= CH_z)
					|| (ch >= CH_A && ch <= CH_Z)) {
				buffer.append(ch);
			}
		}
		return buffer.toString();
	}

	/**
	 * Only one space between2 words.
	 *
	 * @param text the text
	 * @return the string
	 */
	public static String onlyOneSpaceBetween2Words(String text) {
		if (text == null)
			return null;

		StringBuffer buffer = new StringBuffer();
		boolean lastCharIsSpace = false;
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			if (ch == 0x20) {
				if (lastCharIsSpace) {
					continue;
				} else {
					lastCharIsSpace = true;
				}
			} else if (lastCharIsSpace) {
				lastCharIsSpace = false;
			}
			buffer.append(ch);
		}
		return buffer.toString();
	}

	/** The Constant seperators. */
	final static String[] seperators = { " ", ".", ",", "-", "_", "=", "/" };

	/**
	 * Checks if is numberic.
	 *
	 * @param sNumber the s number
	 * @return true, if is numberic
	 */
	public static boolean isNumberic(String sNumber) {
		if (sNumber == null || "".equals(sNumber)) {
			return false;
		}
		char ch_max = (char) 0x39;
		char ch_min = (char) 0x30;

		for (int i = 0; i < sNumber.length(); i++) {
			char ch = sNumber.charAt(i);
			if ((ch < ch_min) || (ch > ch_max)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * *************************************************************************
	 * check the input string is an positive integer?.
	 *
	 * @author Hoang Minh Duc
	 * ************************************************************************
	 * @param sInput the s input
	 * @return boolean
	 */
	public static boolean isInteger(String sInput) {
		try {
			if (sInput == null || "".equals(sInput.trim())) return false;
			return sInput.matches("^\\d+(\\\\d+)?$");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	/**
	 * *************************************************************************
	 * check the input string is an positive numberic?.
	 *
	 * @author Hoang Minh Duc
	 * ************************************************************************
	 * @param sInput the s input
	 * @return boolean
	 */
	public static boolean isNumber(String sInput) {
		try {
			if (sInput == null || "".equals(sInput.trim())) return false;
			return sInput.matches("^[-+]?[0-9]*\\.?[0-9]+$");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	/**
	 * *************************************************************************
	 * check the input string is an positive numbers with exponents?.
	 *
	 * @author Hoang Minh Duc
	 * ************************************************************************
	 * @param sInput the s input
	 * @return boolean
	 */
	public static boolean isNumberWithExponents(String sInput) {
		try {
			if (sInput == null || "".equals(sInput.trim())) return false;
			//--If you also want to match numbers with exponents, you can use:
			return sInput.matches("^[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?$");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	/**
	 * Checks if is alphabet.
	 *
	 * @param text the text
	 * @return true, if is alphabet
	 */
	public static boolean isAlphabet(String text) {
		try {
			if (text == null || "".equals(text.trim())) return false;
			return text.matches("[^a-zA-Z0-9_]+$");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	/**
	 * *************************************************************************
	 * check the input string is an integer?.
	 *
	 * @author Hoang Minh Duc
	 * ************************************************************************
	 * @param sInput the s input
	 * @return boolean
	 */
	public static boolean isNumeric(String sInput) {
		if (sInput == null || "".equals(sInput.trim())) return false;
		return sInput.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+$");// ^-\\d+(\\.\\d+)?$
	}
	
	/**  ***********************************************************************. */
	/* GENERATE RANDOM STRING OF CHARACTERS */
	/** *********************************************************************** */
	private static char[] charArray = null; // Holds an array of character (used
	// to get the random character for
	// the random string)
	/** The random. */
	private static Random random = null; // random object
	// Create an arrays of characters (A--Z, 0--9)
	static {
		int numOfChars = 'Z' - 'A' + 1;
		int numOfDigits = '9' - '0' + 1;

		random = new Random(); // create a random object

		charArray = new char[numOfChars + numOfDigits];
		for (int i = 0; i < numOfChars; i++) {
			charArray[i] = (char) ('A' + i);
		}
		for (int i = 0; i < numOfDigits; i++) {
			charArray[numOfChars + i] = (char) ('0' + i);
		}
		// System.out.println(charArray);
	}

	// returns a random string of chars: A--Z, 0--9
	/**
	 * Generate random string.
	 *
	 * @param length the length
	 * @return the string
	 */
	public static String randomString(int length) {
		char[] ch = new char[length];
		for (int i = 0; i < length; i++)
			ch[i] = charArray[random.nextInt(charArray.length)];
		return new String(ch);
	}

	/** The number array. */
	private static char[] numberArray = null;
	static {
	    int numOfDigits = 10;
	    random = new Random();
	    numberArray = new char[numOfDigits];
	    for (int i = 0; i < numOfDigits; i++) {
	      numberArray[i] = (char)(48 + i);
	    }
	}
	  
	/**
	 * Generate random number.
	 *
	 * @param length the length
	 * @return the string
	 */
	public static String randomNumberString(int length) {
	    char[] ch = new char[length];
	    for (int i = 0; i < length; i++)
	      ch[i] = numberArray[random.nextInt(numberArray.length)];
	    return new String(ch);
	}
	
	/**
	 * Created at 31-10-2014.
	 *
	 * @author DucHM
	 * @param lenOfRndNumber the len of rnd number
	 * @return the string
	 */
	public static String randNumberString(int lenOfRndNumber) {
		try {
			Random fixRand = new Random();
			String result = "";
			//Tao 1 so ngau nhien nguyen thuoc [0..10]
			for (int i = 0; i < lenOfRndNumber; i++) result += String.valueOf(fixRand.nextInt(10)); 
			return result;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * Created at 28-02-2015
	 *
	 * @author DucHM
	 * @param lenOfRndNumber the length of random number
	 * @return the string
	 */
	public static String randNumberStringNotStartWithsZero(int lenOfRndNumber) {
		try {
			Random fixRand = new Random();
			String result = "";
			int min = 1, max = 9;
			//Tao 1 so ngau nhien nguyen tu 0-9
			for (int i = 0; i < lenOfRndNumber; i++) {
				result += String.valueOf(fixRand.nextInt((max - min) + 1) + min); 
			}
			return result;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * Created at 28-02-2015.
	 *
	 * @author DucHM
	 * @param min 
	 * The smallest integer
	 * @param max 
	 * The largest integer
	 * @return the integer
	 */
	public static int randIntInBetween(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	/**
	 * DucHM.
	 *
	 * @param s the s
	 * @return the string
	 */
	public static String normal(String s) {
		try {
			if (isEmptyOrNull(s)) return "";
			return s.replaceAll("[^a-zA-Z0-9]+","");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
	
    /**
     * Tests if a code point is "whitespace" as defined in the HTML spec.
     * @param c code point to test
     * @return true if code point is whitespace, false otherwise
     */
    public static boolean isWhitespace(int c){
        return c == ' ' || c == '\t' || c == '\n' || c == '\f' || c == '\r';
    }

    /**
     * Normalise the whitespace within this string; multiple spaces collapse to a single, and all whitespace characters
     * (e.g. newline, tab) convert to a simple space
     * @param string content to normalise
     * @return normalised string
     */
    public static String normaliseWhitespace(String string) {
        StringBuilder sb = new StringBuilder(string.length());
        appendNormalisedWhitespace(sb, string, false);
        return sb.toString();
    }
    
    /**
     * After normalizing the whitespace within a string, appends it to a string builder.
     * @param accum builder to append to
     * @param string string to normalize whitespace within
     * @param stripLeading set to true if you wish to remove any leading whitespace
     * @return
     */
    public static void appendNormalisedWhitespace(StringBuilder accum, String string, boolean stripLeading) {
        boolean lastWasWhite = false;
        boolean reachedNonWhite = false;

        int len = string.length();
        int c;
        for (int i = 0; i < len; i+= Character.charCount(c)) {
            c = string.codePointAt(i);
            if (isWhitespace(c)) {
                if ((stripLeading && !reachedNonWhite) || lastWasWhite)
                    continue;
                accum.append(' ');
                lastWasWhite = true;
            }
            else {
                accum.appendCodePoint(c);
                lastWasWhite = false;
                reachedNonWhite = true;
            }
        }
    }
    
	/**
	 * *************************************************************************
	 * Method replaceString.
	 *
	 * @author Hoang Minh Duc
	 * 
	 * Replace substring oldStr in string sStr by newStr
	 * @param sStr the s str
	 * @param oldStr the old str
	 * @param newStr the new str
	 * @return String
	 * ************************************************************************
	 */
	public static String replaceString(String sStr, String oldStr, String newStr) {
		sStr = (sStr == null ? "" : sStr);
		String strVar = sStr;
		String tmpStr = "";
		String finalStr = "";
		int stpos = 0, endpos = 0, strLen = 0;
		while (true) {
			strLen = strVar.length();
			stpos = 0;
			endpos = strVar.indexOf(oldStr, stpos);
			if (endpos == -1)
				break;
			tmpStr = strVar.substring(stpos, endpos);
			tmpStr = tmpStr.concat(newStr);
			strVar = strVar.substring(
					endpos + oldStr.length() > sStr.length() ? endpos : endpos
							+ oldStr.length(), strLen);
			finalStr = finalStr.concat(tmpStr);
			stpos = endpos;
		}
		finalStr = finalStr.concat(strVar);
		return finalStr;
	}

	/**
	 * Checks if is empty or null.
	 *
	 * @param input the input
	 * @return true, if is empty or null
	 */
	public static boolean isEmptyOrNull(String input) {
		if (input == null) return true;
		if (input.trim().length() == 0 || "null".equalsIgnoreCase(input.trim())) return true;
		return false;
	}
	
	/**
	 * Checks if is empty or null.
	 *
	 * @param input the object
	 * @return true, if is empty or null
	 */
	public static boolean isEmptyOrNull(Object input) {
		if (input == null) return true;
		if (nullToEmpty(input).trim().length() == 0) return true;
		return false;
	}
	
	/**
	 * *************************************************************************
	 * Method check StringBuffer isEmptyOrNull.
	 *
	 * @param input the input
	 * @return boolean
	 *  * @author Hoang Minh Duc
	 * ************************************************************************
	 */
	public static boolean isEmptyOrNull(StringBuffer input) {
		if (input == null) return true;
		String sInput = input.toString();
		if (sInput.trim().length() == 0) return true;
		return false;
	}

	/**
	 * *************************************************************************
	 * Method check StringBuilder isEmptyOrNull.
	 *
	 * @param input the input
	 * @return boolean
	 *  * @author Hoang Minh Duc
	 * ************************************************************************
	 */
	public static boolean isEmptyOrNull(StringBuilder input) {
		if (input == null) return true;
		String sInput = nullToEmpty(input).trim();
		//if ("".equals(sInput.trim())) return true;
		if (sInput.length() == 0) return true;
		return false;
	}
	
/*	public static boolean isEmptyOrNull(StringBuilder input) {
		if (input == null)
			return true;
		int cs = 0;
		while (input.length() > 0 && input.charAt(cs) == ' ') {
			input = input.deleteCharAt(cs);
		}
		if ("".equals(input))
			return true;
		if (input != null && input.length() == 0) return true;
		return false;
	}*/
	
	/**
	 * Null to empty.
	 *
	 * @param input the input
	 * @return the string
	 */
	public static String nullToEmpty(Object input) {
		return (input == null ? "" : ("null".equals(input)?"": input.toString()));
	}

	/**
	 * Find number.
	 *
	 * @param sNumber the s number
	 * @return the int
	 */
	public static int findNumber(String sNumber) {

		int result = -1;
		if (sNumber == null || "".equals(sNumber)) {
			return result;
		}
		char ch_max = (char) 0x39;
		char ch_min = (char) 0x30;

		for (int i = 0; i < sNumber.length(); i++) {
			char ch = sNumber.charAt(i);
			if ((ch < ch_min) || (ch > ch_max)) {

			} else {
				result = i;
				break;
			}
		}
		return result;
	}

	/**
	 * Find char.
	 *
	 * @param sNumber the s number
	 * @return the int
	 */
	public static int findChar(String sNumber) {

		int result = 0;
		if (sNumber == null || "".equals(sNumber)) {
			return result;
		}
		char ch_max = (char) 0x39;
		char ch_min = (char) 0x30;

		for (int i = 0; i < sNumber.length(); i++) {
			char ch = sNumber.charAt(i);
			if ((ch < ch_min) || (ch > ch_max)) {
				result = i;
				break;
			}
		}
		return result;
	}

	/**
	 * S chuan hoa ten.
	 *
	 * @param input the input
	 * @return the string
	 */
	public static String sChuanHoaTen(String input) {
		if (StringUtils.isEmptyOrNull(input)) return "";
		input = input.trim();
		StringBuffer sb = new StringBuffer();
		sb.append(String.valueOf(input.charAt(0)).toUpperCase());
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i - 1) == ' ') {
				sb.append(String.valueOf(input.charAt(i)).toUpperCase());
			} else {
				sb.append(String.valueOf(input.charAt(i)).toLowerCase());
			}
		}
		return sb.toString();
	}

	// /<summary>
	// / Chuan hoa mang
	// / VD: A{"aa","er","","45","","","4df","sdf",""}
	// / Sau khi chuan hoa:A{"aa","er","45","4df","sdf"}
	// /</summary>
	/**
	 * Normalize array.
	 *
	 * @param Arr the arr
	 * @return the string[]
	 */
	public static String[] normalizeArray(String[] Arr) {
		try {
			if (Arr == null) return null;
			int i = 0;
			int len = Arr.length;
			while (i < len) {
				if ("".equals(Arr[i]) || " ".equals(Arr[i]) || (Arr[i] == null)) {
					for (int j = i; j < len - 1; j++) Arr[j] = Arr[j + 1];
					len = len - 1;
				} else i++;
			}
			String[] temp = new String[len];
			for (int k = 0; k < len; k++)
				temp[k] = Arr[k];
			return temp;
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * Concatenation two array input into array destination.
	 *
	 * @author Hoang Minh Duc<br>
	 * @param One the one
	 * @param Two the two
	 * @return the string[]
	 */
	public static String[] addUpTowArray(String[] One, String[] Two) {
		try {
			if ((One == null) && (Two == null))
				return null;
			if ((One == null) && (Two != null))
				return Two;
			if ((One != null) && (Two == null))
				return One;
			String[] ArrTemp = new String[One.length + Two.length];
			int element = -1;
			for (int i = 0; i < One.length; i++) {
				element = element + 1;
				ArrTemp[element] = One[i];
			}
			for (int j = 0; j < Two.length; j++) {
				element = element + 1;
				ArrTemp[element] = Two[j];
			}
			return ArrTemp;
		} catch (Exception e) {
		}
		return null;
	}
	
	  /**
  	 * concatenates two arrays of strings.
  	 *
  	 * @author Hoang Minh Duc: 0989664386<br>
  	 * @param s1 the first array of strings.
  	 * @param s2 the second array of strings.
  	 * @return the resulting array with all strings in s1 and s2
  	 */
	 public static String[] concatArray(String[] s1, String[] s2) {
		 try {
				if ((s1 == null) && (s2 == null)) return null;
				if ((s1 == null) && (s2 != null)) return s2;
				if ((s1 != null) && (s2 == null)) return s1;

				String[] result = new String[s1.length + s2.length];
				System.arraycopy(s1, 0, result, 0, s1.length);
				System.arraycopy(s2, 0, result, s1.length, s2.length);
				return result;
		} catch (Exception e) {
		}
		return null;
	}

	 /**
 	 * Attach elements of tow array.
 	 *
 	 * @param s1 the s1
 	 * @param s2 the s2
 	 * @return the string[]
 	 */
 	public static String[] attachElementsOfTowArray(String[] s1, String[] s2) {
		 try {
				if ((s1 == null) && (s2 == null)) return null;
				if ((s1 == null) && (s2 != null)) return s2;
				if ((s1 != null) && (s2 == null)) return s1;

				if (s1.length != s2.length) return null;
				
				String[] result = new String[s1.length];
				for (int i = 0; i < result.length; i++) {
					result[i] = s1[i].concat(s2[i]);
				}
				return result;
		} catch (Exception e) {
		}
		return null;
	}
	 
	 /**
 	 * Attach elements of array.
 	 *
 	 * @param array the array
 	 * @param attach the attach
 	 * @param beforeOrAfter the before or after
 	 * @return the string[]
 	 */
 	public static String[] attachElementsOfArray(String[] array, String attach, boolean beforeOrAfter) {
		 try {
				if (array == null) return null;
				if ((array != null) && StringUtils.isEmptyOrNull(attach)) return array;
				String[] result = new String[array.length];
				if (beforeOrAfter) {
					for (int i = 0; i < result.length; i++) {
						result[i] = attach.concat(array[i]);
					}
				} else {
					for (int i = 0; i < result.length; i++) {
						result[i] = array[i].concat(attach);
					}
				}
				return result;
		} catch (Exception e) {
		}
		return null;
	}
	 
	 
	/**
	 * *************************************************************************
	 * Method split String input with parameter compare is regex<br>.
	 *
	 * @author Hoang Minh Duc<br>
	 * @param input the input
	 * @param param the param
	 * @return String[]
	 * ************************************************************************
	 */
	public static String[] splits(String input, String param) {
		try {
			if (input == null || "".equals(input.trim())) return null;
			if (input.indexOf(param) < 0) return new String[]{input};
			Vector v = new Vector();
			int index = 0;
			while ((index = input.indexOf(param)) >= 0) {
				String s = input.substring(0, index);
				input = input.substring(index + param.length());
				v.addElement(s);
			}
			v.addElement(input);
			String[] arr = new String[v.size()];
			v.copyInto(arr);
			return arr;
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * Normalize whitespaces.
	 *
	 * @param input the input
	 * @return the string
	 */
	public static String normalizeWhitespaces(String input) {
		if (StringUtils.isEmptyOrNull(input)) return null;
		StringBuffer res = new StringBuffer();
		int prevIndex = 0;
		int currIndex = -1;
		int stringLength = input.length();
		String searchString = "  ";
		while ((currIndex = input.indexOf(searchString, currIndex + 1)) >= 0) {
			res.append(input.substring(prevIndex, currIndex + 1));
			while (currIndex < stringLength && input.charAt(currIndex) == ' ') {
				currIndex++;
			}
			prevIndex = currIndex;
		}
		res.append(input.substring(prevIndex));
		return res.toString();
	}
	
    public static boolean contains(String needle, String... haystack) {
        for (String hay : haystack) {
            if (hay.equals(needle))
            return true;
        }
        return false;
    }
    
    public static boolean containsIgnoreCase(String needle, String... haystack) {
        for (String hay : haystack) {
            if (hay.equalsIgnoreCase(needle))
            return true;
        }
        return false;
    }
	/**
	 * *************************************************************************
	 * Method copy many element from array source in to array destination\n
	 * start position first to position last\n.
	 *
	 * @author Hoang Minh Duc\n
	 * @param source the source
	 * @param nBegin the n begin
	 * @param nEnd the n end
	 * @return String[]\n VD: source{"10","20","90","99","100"}
	 *         nBegin=1;nEnd=3\n KQ: target{"20","90","99"}
	 * ************************************************************************
	 */
    public static String[] copyArray(String[] source, int nBegin, int nEnd) {
    	try {
            if ((source == null) || (source != null && source.length == 0) || (nBegin > nEnd)) return null;
            if (nEnd >= source.length) nEnd = source.length - 1;
            String[] target = new String[nEnd - nBegin + 1];
            int cs = 0;
            for (int i = nBegin; i <= nEnd; i++) {
                target[cs] = source[i];
                cs++;
            }
            return target;
		} catch (Exception e) {
		}
		return null;
    }
    
	/**
	 * *************************************************************************
	 * Method remove element of array source at position index is value input\n.
	 *
	 * @author Hoang Minh Duc\n
	 * @param source the source
	 * @param index the index
	 * @return String[]\n
	 * VD: source{"10","20","90","99","100"} index=1\n
	 *     KQ: target{"10","90","99","100"}
	 * ************************************************************************
	 */
    public static String[] removeElementOfArray(String[] source, int index) {
    	try {
            if (source == null || (source != null && source.length == 0)) return null;
            if (source != null && index > source.length) return source;
            String[] target = new String[source.length - 1];
            int cs = 0;
            for (int i = 0; i < source.length; i++){
            	if (i != index){
    	            target[cs] = source[i];
    	            cs++;
            	}
            }
            return target;
		} catch (Exception e) {
		}
		return null;
    }
    
   /**
    * repalce all String parameter replace with String parameter with in data String.
    *
    * @author Hoang Minh Duc: 0989664386<br>
    * @param input the input
    * @param replace the replace
    * @param with the with
    * @return the string
    */
    public static String replaceAll(String input, String replace, String with) {
		try {
			if (input == null || "".equals(input)) return null;
			if (replace == null || "".equals(replace)) return input;
			if (input.length() < replace.length()) return input;
			int from = -1;
			while ((from = input.indexOf(replace)) > -1) {
				input = input.substring(0, from) + with + input.substring(from + replace.length());
			}
			return input;
		} catch (Exception e) {
		}
		return null;
	}
    
    /**
     * repalce String parameter replace with String parameter with in data String.
     *
     * @author Hoang Minh Duc: 0989664386<br>
     * @param input the input
     * @param replace the replace
     * @param with the with
     * @return the string
     */
    public static String replace(String input, String replace, String with) {
		try {
			if (input == null || "".equals(input)) return null;
			if (replace == null || "".equals(replace)) return input;
			if (input.length() < replace.length()) return input;
			int from = input.indexOf(replace);
			if (from > -1) {
				input = input.substring(0, from) + with + input.substring(from + replace.length());
			}
			return input;
		} catch (Exception e) {
		}
		return null;
	}
    
    /**
     * repalce String parameter replace with String parameter with in data String.
     *
     * @author Hoang Minh Duc: 0989664386<br>
     * @param input the input
     * @param replace the replace
     * @param with the with
     * @return the string
     */
    public static String replaceAllWithoutLastElement(String input, String replace, String with) {
		try {
			if (input == null || "".equals(input)) return null;
			if (replace == null || "".equals(replace)) return input;
			if (input.length() < replace.length()) return input;
			int from = -1;
			int lastIndexOf = input.lastIndexOf(replace);
			while ((from = input.indexOf(replace)) > -1 && from != lastIndexOf) {
				input = input.substring(0, from) + with + input.substring(from + replace.length());
			}
			return input;
		} catch (Exception e) {
		}
		return null;
	}
    
    /**
     * repalce all String parameter replace with String parameter with in data String[].
     *
     * @author Hoang Minh Duc: 0989664386<br>
     * @param input the input
     * @param replace the replace
     * @param with the with
     * @return the string[]
     */
      public static String[] replaceAll(String[] input, String replace, String with) {
  		try {
  			if (input == null) return null;
  	  		if (replace == null || "".equals(replace)) return input;
  	  		for (int i = 0; i < input.length; i ++) input[i] = replaceAll(input[i], replace, with);
  	  		return input;
		} catch (Exception e) {
		}
		return null;
  	}
      
	/**
	 * *************************************************************************
	 * Method copy many element from array source in to array destination\n
	 * start position first to position last\n.
	 *
	 * @author Hoang Minh Duc\n
	 * @param from the from
	 * @param to the to
	 * @param source the source
	 * @return String[]\n VD: source{"10","20","90","99","100"}
	 *         from = 1;to = 3\n KQ: target{"20","90","99"}
	 * ************************************************************************
	 */
    public static String[] copyArray(int from, int to, String[] source) {
		try {
			if (source == null) return null;
			if (from < 0) return null;
			if (from > to) return null;
			if (to >= source.length) return null;
			String[] target = new String[to - from + 1];
			System.arraycopy(source, from, target, 0, target.length);
			return target;
		} catch (Exception e) {
		}
		return null;
	}
    
	/**
	 * *************************************************************************
	 * Method copy numElement from array source in to array destination\n
	 * start position first to position last\n.
	 *
	 * @author Hoang Minh Duc\n
	 * @param from the from
	 * @param numElement the num element
	 * @param source the source
	 * @return String[]\n VD: source{"10","20","90","99","100"}
	 *         from = 1;numElement = 3\n KQ: target{"20","90","99"}
	 * ************************************************************************
	 */
    public static String[] copyElementsOfArray(int from, int numElement, String[] source) {
		try {
			if (source == null) return null;
			if (from < 0) return null;
			if (from + numElement > source.length) return null;
			String[] target = new String[numElement];
			System.arraycopy(source, from, target, 0, target.length);
			return target;
		} catch (Exception e) {
		}
		return null;
	}
    
    /**
     * method get index of element in string array .
     *
     * @param input the input
     * @param element the element
     * @return the index element of array
     */
    public static int getIndexElementOfArray(String[] input, String element) {
    	if (input == null || isEmptyOrNull(element)) return -1;
    	int idx = -1;// not exists
    	for (int i = 0; i < input.length; i++) {
    		if (element.equals(input[i])) return i;
    	}
    	return idx;
    }
    
	/**
	 * *************************************************************************
	 * Method copy many element from array source in to array destination\n
	 * start position first to position last\n.
	 *
	 * @author Hoang Minh Duc\n
	 * @param idxFrom the idxFrom
	 * @param idxTo the idxTo
	 * @param source the source
	 * @return ArrayList<String>\n VD: source{"10","20","90","99","100"}
	 *         idxFrom = 1;idxTo = 3\n KQ: target{"20","90","99"}
	 * ************************************************************************
	 */
    public static ArrayList<String> copyArrayList(int idxFrom, int idxTo, ArrayList<String> source) {
		try {
			if (source == null) return null;
			if (idxFrom < 0) return null;
			if (idxFrom > idxTo) return null;
			if (idxTo >= source.size()) return null;
			ArrayList<String> target = new ArrayList<String>(idxTo - idxFrom + 1);
			for (int idx = idxFrom; idx <= idxTo; idx++) {
				target.add(source.get(idx));
			}
			return target;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    
    // dd-MM-yyyy hh:mm
    // dd/MM/yyyy hh:mm
    /**
     * String to datedd m myyyyhhmm.
     *
     * @param ddMMyyyyhhmm the dd m myyyyhhmm
     * @return the date
     */
    public static Date stringToDateddMMyyyyhhmm(String ddMMyyyyhhmm) {
    	if (isEmptyOrNull(ddMMyyyyhhmm)) return null;
    	ddMMyyyyhhmm = ddMMyyyyhhmm.replace('/', '-');
		Date dt;
		Calendar cal = Calendar.getInstance();
		String strArr[] = splits(ddMMyyyyhhmm, " ");
		if (strArr.length > 0) {
			String strDMY[] = splits(strArr[0], "-");
			String strHM[] = splits(strArr[1], ":");
			cal.setTime(new Date());
			cal.set(Calendar.YEAR, Integer.parseInt("0" + strDMY[2]));
			cal.set(Calendar.MONTH, Integer.parseInt("0" + strDMY[1]));
			cal.set(Calendar.DATE, Integer.parseInt("0" + strDMY[0]));
			cal.set(Calendar.HOUR, Integer.parseInt("0" + strHM[1]));
			cal.set(Calendar.MINUTE, Integer.parseInt("0" + strHM[0]));
			dt = cal.getTime();
			return dt;
		}
		return null;
	}
    
    /**
     * String to datedd m myyyy.
     *
     * @param ddMMyyyy the dd m myyyy
     * @return the date
     */
    public static Date stringToDateddMMyyyy(String ddMMyyyy) {
    	if (isEmptyOrNull(ddMMyyyy)) return null;
    	ddMMyyyy = ddMMyyyy.replace('/', '-');
		Date dt;
		Calendar cal = Calendar.getInstance();
		String strArr[] = splits(ddMMyyyy, " ");
		if (strArr.length > 0) {
			String strDMY[] = splits(strArr[0], "-");
			cal.setTime(new Date());
			cal.set(Calendar.YEAR, Integer.parseInt("0" + strDMY[2]));
			cal.set(Calendar.MONTH, Integer.parseInt("0" + strDMY[1]));
			cal.set(Calendar.DATE, Integer.parseInt("0" + strDMY[0]));
			dt = cal.getTime();
			return dt;
		}
		return null;
	}
    
    
    /**
     * *************************************************************************
     * Method check String isValidDate.
     *
     * @author Hoang Minh Duc
     * ************************************************************************
     * @param ddMMyyyy the dd m myyyy
     * @return boolean
     */
    public static boolean isValidDate(String ddMMyyyy) {
    	try {
    		if (isEmptyOrNull(ddMMyyyy) || "null".equals(ddMMyyyy)) return false;
    		if (ddMMyyyy.startsWith("/") || ddMMyyyy.startsWith(" ") || ddMMyyyy.startsWith("-")) {
    			ddMMyyyy = ddMMyyyy.substring(1);
    		}
    		if (ddMMyyyy.endsWith("/") || ddMMyyyy.endsWith(" ") || ddMMyyyy.endsWith("-")) {
    			ddMMyyyy = ddMMyyyy.substring(0, ddMMyyyy.length() - 1);
    		}
    		if (ddMMyyyy.length() != 10 && ddMMyyyy.length() != 8) return false;
    		if (ddMMyyyy.length() == 8 && (ddMMyyyy.indexOf("/") != -1 || ddMMyyyy.indexOf("-") != -1 || ddMMyyyy.indexOf(" ") != -1)) return false;
    		if (ddMMyyyy.length() == 8) {
    			ddMMyyyy = ddMMyyyy.substring(0, 2) + "-" + ddMMyyyy.substring(2, 4) + "-" + ddMMyyyy.substring(4);
    		}
    		ddMMyyyy = replaceAll(ddMMyyyy, "/", "-");
    		ddMMyyyy = replaceAll(ddMMyyyy, " ", "-");
    		String[] arrDate = splits(ddMMyyyy, "-");
    		if (arrDate == null) return false;
    		if (arrDate.length != 3) return false;
    		int dd = 0;
    		int mm = 0;
    		int yyyy = 0;
    		try {
    			dd = Integer.parseInt(arrDate[0]);
    			mm = Integer.parseInt(arrDate[1]);
    			yyyy = Integer.parseInt(arrDate[1]);
			} catch (NumberFormatException e) {
				return false;
			}
    		if (arrDate[0].length() == 2 && dd > 0 && dd < 32 && arrDate[1].length() == 2 && mm > 0 && mm < 13 && arrDate[2].length() == 4 && yyyy != 0) return true;
		} catch (Exception e) {
		}
		return false;
	}
    // get formatDate for String
    /**
     * Format date.
     *
     * @param ddMMyyyy the dd m myyyy
     * @return the string
     */
    public static String formatDate(String ddMMyyyy) {
    	try {
    		String regex = "/";
    		if (isEmptyOrNull(ddMMyyyy) || "null".equals(ddMMyyyy)) return "";
    		if (ddMMyyyy.startsWith("/") || ddMMyyyy.startsWith(" ") || ddMMyyyy.startsWith("-")) {
    			ddMMyyyy = ddMMyyyy.substring(1);
    		}
    		if (ddMMyyyy.endsWith("/") || ddMMyyyy.endsWith(" ") || ddMMyyyy.endsWith("-")) {
    			ddMMyyyy = ddMMyyyy.substring(0, ddMMyyyy.length() - 1);
    		}
    		if (ddMMyyyy.length() != 10 && ddMMyyyy.length() != 8) return "";
    		if (ddMMyyyy.length() == 8 && (ddMMyyyy.indexOf("/") != -1 || ddMMyyyy.indexOf("-") != -1 || ddMMyyyy.indexOf(" ") != -1)) return "";
    		if (ddMMyyyy.length() == 8) {
    			ddMMyyyy = ddMMyyyy.substring(0, 2) + "-" + ddMMyyyy.substring(2, 4) + "-" + ddMMyyyy.substring(4);
    		}
    		if (ddMMyyyy.indexOf("/") != -1) regex = "/";
    		if (ddMMyyyy.indexOf("-") != -1) regex = "-";
    		if (ddMMyyyy.indexOf(" ") != -1) regex = " ";
    		
    		ddMMyyyy = replaceAll(ddMMyyyy, "/", "-");
    		ddMMyyyy = replaceAll(ddMMyyyy, " ", "-");
    		String[] arrDate = splits(ddMMyyyy, "-");
    		if (arrDate == null) return "";
    		if (arrDate.length != 3) return "";
    		int dd = 0;
    		int mm = 0;
    		int yyyy = 0;
    		try {
    			dd = Integer.parseInt(arrDate[0]);
    			mm = Integer.parseInt(arrDate[1]);
    			yyyy = Integer.parseInt(arrDate[1]);
			} catch (NumberFormatException e) {
				return "";
			}
    		if (arrDate[0].length() == 2 && dd > 0 && dd < 32 && arrDate[1].length() == 2 && mm > 0 && mm < 13 && arrDate[2].length() == 4 && yyyy != 0) {
    			return "dd" + regex + "mm" + regex + "yyyy";
    		}
		} catch (Exception e) {
		}
		return "";
	}
    
    /**
     * Checks if is valid date.
     *
     * @param ddMMyyyy the dd m myyyy
     * @return true, if is valid date
     */
    public static boolean isValidDate(StringBuffer ddMMyyyy) {
    	if (isEmptyOrNull(ddMMyyyy)) return false;
    	return (isValidDate(ddMMyyyy.toString()));
	}
    
    /**
     * Checks if is valid date.
     *
     * @param ddMMyyyy the dd m myyyy
     * @return true, if is valid date
     */
    public static boolean isValidDate(StringBuilder ddMMyyyy) {
    	if (isEmptyOrNull(ddMMyyyy)) return false;
    	return (isValidDate(ddMMyyyy.toString()));
	}
    
    /**
     * Convert string array to vector.
     *
     * @param input the input
     * @return the vector
     */
    public static Vector<String> convertStringArrayToVector(String[] input) {
    	if (input == null) return null;
    	Vector<String> vec = new Vector<String>();
    	vec.addAll(Arrays.asList(input));
    	return vec;
    }
    
	/**
	 * Validate whether the argument string can be parsed into a 
	 * legal date.<br />
	 * 
	 * Does check for formating errors and illegal data (so an invalid
	 * month or day number is detected).
	 *
	 * @author Hoang Minh Duc
	 * @param dateStr the date str
	 * @param allowPast set to true to allow dates in the past, false if
	 * only dates in the future should be allowed.
	 * @param formatStr date format string to be used to validate against
	 * @return true if a correct date and conforms to the restrictions
	 */
	public static boolean isValidDate(String dateStr, boolean allowPast, String formatStr) {
        if (formatStr == null) return false; // or throw some kinda exception, possibly a InvalidArgumentException
		SimpleDateFormat df = new SimpleDateFormat(formatStr);
		Date testDate = null;
		try {
			testDate = df.parse(dateStr);
		} catch (java.text.ParseException e) {
			// invalid date format
			return false;
		}
		if (!allowPast) {
			// initialise the calendar to midnight to prevent the current day from being rejected
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			if (cal.getTime().after(testDate)) return false;
		}
		// now test for legal values of parameters
		if (!df.format(testDate).equals(dateStr)) return false;
		return true;
	}
	
	/**
	 * Checks if is valid date new.
	 *
	 * @author Hoang Minh Duc
	 * @param sDate the s date
	 * @param fomat the fomat
	 * @return true, if is valid date new
	 */
	public static boolean isValidDateNew(String sDate, String fomat) {
	    if (isEmptyOrNull(sDate)) return false;
	    //set the format to use as a constructor argument
		SimpleDateFormat dateFormat = new SimpleDateFormat(fomat);
		if (sDate.trim().length() != dateFormat.toPattern().length()) return false;
		dateFormat.setLenient(false);
		//parse the sDate parameter
		try {
			dateFormat.parse(sDate.trim());
		} catch (java.text.ParseException e) {
			return false;
		}
	    return true;
	}
	
	/**
	 * Checks if is 8x93 service number.
	 *
	 * @param sServiceNumber the s service number
	 * @return true, if is 8x93 service number
	 */
	public static boolean is8x93ServiceNumber(String sServiceNumber) {
		String s8x93ServiceNumber = "8093,8193,8293,8393,8493,8593,8693,8793";
		if (isInteger(sServiceNumber) && s8x93ServiceNumber.contains(sServiceNumber)) return true;
		return false;
	}
	
	/**
	 * Checks if is phone number.
	 *
	 * @param sPhoneNumber the s phone number
	 * @return true, if is phone number
	 */
	public static boolean isPhoneNumber(String sPhoneNumber) {
		if (sPhoneNumber == null || "".equals(sPhoneNumber.trim())) return false;
		return sPhoneNumber.matches("^[0-9]{10,11}");
	}
	
	/**
	 * check a String is vietnames mobile phone.
	 *
	 * @author Hoàng Minh Đức: 0989664386
	 * @param sPhoneNumber the s phone number
	 * @return true, if is viet name mobile phone
	 */
	public static boolean isVietNameMobilePhone(String sPhoneNumber) {
		if (sPhoneNumber == null || "".equals(sPhoneNumber.trim())) return false;
		return sPhoneNumber.matches("^(09\\d{8}|01\\d{9}|84\\d{9,10})");
	}
	
	/**
	 * Checks if is email.
	 *
	 * @param sEmail the s email
	 * @return true, if is email
	 */
	public static boolean isEmail(String sEmail) {
		if (sEmail == null || "".equals(sEmail.trim())) return false;
		return sEmail.matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b");
		//^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$
	}

	/**
	 * Split.
	 *
	 * @param str the str
	 * @param sep the sep
	 * @param maxNum the max num
	 * @return the string[]
	 */
	public static String[] split(String str, char sep, int maxNum) {
		if ((str == null) || (str.length() == 0)) {
			return new String[0];
		}

		Vector results = maxNum == 0 ? new Vector() : new Vector(maxNum);

		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c == sep) {
				if ((maxNum != 0) && (results.size() + 1 == maxNum)) {
					for (; i < str.length(); i++) {
						buf.append(str.charAt(i));
					}
				}
				results.addElement(buf.toString());
				buf.setLength(0);
			} else {
				buf.append(c);
			}
		}

		if (buf.length() > 0) {
			results.addElement(buf.toString());
		}

		return toStringArray(results);
	}
	
	/**
	 * To string array.
	 *
	 * @param strings the strings
	 * @return the string[]
	 */
	private static String[] toStringArray(Vector strings) {
		String[] result = new String[strings.size()];
		for (int i = 0; i < strings.size(); i++) {
			result[i] = strings.elementAt(i).toString();
		}
		return result;
	}
	
	/**
	 * Chomp.
	 *
	 * @param inStr the in str
	 * @return the string
	 */
	public static String chomp(String inStr) {
		if ((inStr == null) || ("".equals(inStr))) {
			return inStr;
		}

		char lastChar = inStr.charAt(inStr.length() - 1);
		if (lastChar == '\r') {
			return inStr.substring(0, inStr.length() - 1);
		}
		if (lastChar == '\n') {
			String tmp = inStr.substring(0, inStr.length() - 1);
			if ("".equals(tmp)) {
				return tmp;
			}
			lastChar = tmp.charAt(tmp.length() - 1);
			if (lastChar == '\r') {
				return tmp.substring(0, tmp.length() - 1);
			}

			return tmp;
		}

		return inStr;
	}
	
	/**
	 * Create a random string of letters and digits alternating, no duplicate letters and numbers.
	 *
	 * @author mobile.apps.pro.vn@gmail.com
	 * @param LenOfRndNumber the len of rnd number
	 * @return String
	 */
	public static String genRandomString(int LenOfRndNumber) {
		String result = "";
		try {
			String[] chars = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
			String[] numbers = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
			Random fixRand = new Random();

			int status = fixRand.nextInt(2);// 0 is random number; 1 is random number
			int idx = 0;
			int i = 0;
			while (i < LenOfRndNumber) {
				idx = fixRand.nextInt(10);// 0 <= idx < 10
				if (status == 0 && !result.contains(numbers[idx])) {
					status = 1;
					result += numbers[idx];
					i++;
				} else if (status == 1 && !result.contains(chars[idx])) {
					status = 0;
					result += chars[idx];
					i++;
				}
			}
		} catch (Exception e) {
		}
		return result;
	}
	
	/**
	 * Create a random string of letters and digits alternating, no duplicate letters and numbers.
	 *
	 * @author duchm@vtm.vn
	 * @param LenOfRndNumber the len of rnd number
	 * @return String
	 */
	public static String genRandomStringNew(int LenOfRndNumber) {
		String result = "";
		try {
			String[] chars = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
			Random fixRand = new Random();

			int status = fixRand.nextInt(2);// 0 is random number; 1 is random number
			int idx = 0;
			int i = 0;
			while (i < LenOfRndNumber) {
				idx = fixRand.nextInt(10);// 0 <= idx < 10
				if (status == 0 && !result.contains("" + idx)) {
					status = 1;
					result += "" + idx;
					i++;
				} else if (status == 1 && !result.contains(chars[idx])) {
					status = 0;
					result += chars[idx];
					i++;
				}
			}
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * Gets the random int in between.
	 *
	 * @param min the min
	 * @param max the max
	 * @return the random int in between
	 */
	public static int randomIntInBetween(int min, int max) {
		Random rand = new Random();
		return min + rand.nextInt(max - min);
	}

    
	public static Map<String, String> getQueryMap(String query) {
		if (isEmptyOrNull(query)) return null;
	    String[] params = query.split("&");
	    Map<String, String> map = new HashMap<String, String>();
	    for (String param : params) {
	        try {
	        	String name = param.split("=")[0];
		        String value = param.split("=")[1];
		        map.put(name, value);
			} catch (Exception e) {
			}
	    }
	    return map;
	}
	
	public static int stringToInt(String strVal, int intDefault) {
	    try {
	        return Integer.parseInt(strVal);
	    } catch (NumberFormatException e) {
	        return intDefault;
	    }
	}
	
    /**
     * Returns a string containing the tokens joined by delimiters.
     * @param tokens an array objects to be joined. Strings will be formed from
     *     the objects by calling object.toString().
     */
    public static String join(CharSequence delimiter, Object[] tokens) {
        StringBuilder sb = new StringBuilder();
        boolean firstTime = true;
        for (Object token: tokens) {
            if (firstTime) {
                firstTime = false;
            } else {
                sb.append(delimiter);
            }
            sb.append(token);
        }
        return sb.toString();
    }

    /**
     * Returns a string containing the tokens joined by delimiters.
     * @param tokens an array objects to be joined. Strings will be formed from
     *     the objects by calling object.toString().
     */
    public static String join(CharSequence delimiter, Iterable tokens) {
        StringBuilder sb = new StringBuilder();
        boolean firstTime = true;
        for (Object token: tokens) {
            if (firstTime) {
                firstTime = false;
            } else {
                sb.append(delimiter);
            }
            sb.append(token);
        }
        return sb.toString();
    }
    
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		HashMap<String, ArrayList<String>> has = new HashMap<String, ArrayList<String>>();
		ArrayList<String> tmp = new ArrayList<String>();
		tmp.add("1");
		tmp.add("2");
		tmp.add("3");
		tmp.add("4");
		tmp.add("5");
		
		has.put("key1", tmp);
		
		ArrayList<String> source = has.get("key1");
		ArrayList<String> destination = has.get("key1");//ArrayList<String> destination = source;
		//source = StringUtils.copyArrayList(1, source.size() - 1, source);
		destination.add("99999");
		for (String number : source) {
			System.out.println("source=" + number);
		}
		System.out.println("=================================");
		for (String number : destination) {
			System.out.println("destination=" + number);
		}
		
		//System.out.println(replaceAllWithoutLastElement("/storage/emulated/0/.Okazu/okazu_design/adr_849345438151432306483page5.2.jpg", ".", "_"));
		
		//System.out.println("isAlphabet=" + isAlphabet("半角英数だけで入力"));
		// startItem=1 && numItems=5 & len = 6;
		//String[] result = new String[] {"10","20","90","99","100"};
		//attachElementsOfArray(result, " lần", true);
		/*result = copyElementsOfArray(1, 4, result);
		for (int i = 0; i < result.length; i++) {
			System.out.println("result[" + i + "]=" + result[i]);
		}
		*/
//		System.out.println("------------------------------------------------------------------");
//		StringBuffer sBff = new StringBuffer().append("23/08/2011");
//		System.out.println("sBff=" + isValidDate(sBff));
//		System.out.println("------------------------------------------------------------------");
//		System.out.println("IM NAP 0348729814|8693".substring("IM NAP 0348729814|8693".indexOf("|") + 1));
		//---------------------------------------------------//
		//System.out.println(isValidDate("11/12/2011"));
		
		//String s = "abc<b>-123df-345-ds-ertm-mre</b>";
		//System.out.println(s.substring(s.indexOf("</b>") + "</b>".length()));
	}
}
