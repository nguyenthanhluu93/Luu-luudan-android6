package com.gvn.pets.utils;

import java.lang.Character.UnicodeBlock;
import java.util.HashSet;

/**
 * @author Created by Robert Hoang on 22 Nov 2016
 */
public class JapaneseValidator {
	public final static HashSet<UnicodeBlock> japaneseBlocks = new HashSet<UnicodeBlock>();
    static {
    	japaneseBlocks.add(UnicodeBlock.SPACING_MODIFIER_LETTERS);
    	//japaneseBlocks.add(Character.UnicodeBlock.SPECIALS);
    	japaneseBlocks.add(UnicodeBlock.NUMBER_FORMS);
    	japaneseBlocks.add(UnicodeBlock.LATIN_1_SUPPLEMENT);
    	japaneseBlocks.add(UnicodeBlock.LATIN_EXTENDED_A);
    	japaneseBlocks.add(UnicodeBlock.LATIN_EXTENDED_ADDITIONAL);
    	japaneseBlocks.add(UnicodeBlock.LATIN_EXTENDED_B);
    	/*japaneseBlocks.add(Character.UnicodeBlock.LATIN_EXTENDED_C);
    	japaneseBlocks.add(Character.UnicodeBlock.LATIN_EXTENDED_D);*/
    	japaneseBlocks.add(UnicodeBlock.BASIC_LATIN);
        japaneseBlocks.add(UnicodeBlock.KATAKANA);
        japaneseBlocks.add(UnicodeBlock.HIRAGANA);
        japaneseBlocks.add(UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS);
        japaneseBlocks.add(UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A);
        // add other blocks as necessary
    }
    
    public static boolean isAllJapanese(String input) {
        for (int i = 0, max = input.length(); i < max; i++) {
            char c = input.charAt(i);
            UnicodeBlock block = UnicodeBlock.of(c);
            if (!japaneseBlocks.contains(block))
                return false;
        }
        return true;
    }
    
    public static boolean validatePassword(String input) {
        for (int i = 0, max = input.length(); i < max; i++) {
            char c = input.charAt(i);
            UnicodeBlock block = UnicodeBlock.of(c);
            if (!japaneseBlocks.contains(block))
                return false;
        }
        return true;
    }
    
    /**
     ********************************************************* 
     */
    public static void main(String[] args) {
    	String input = "誰がインスタールですかA12 3a漢字 日本語文字言語言葉xcv";
		System.out.println(isAllJapanese(input.trim()));
	}
}