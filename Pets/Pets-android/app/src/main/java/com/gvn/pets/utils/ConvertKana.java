package com.gvn.pets.utils;

/**
 * 
 * @author Created by Robert Hoang on 22 Nov 2016
 *
 */
public class ConvertKana {
	/**
	 * Zenkaku=ゴ
	 * Hankaku=ｺﾞ
	 * @param str
	 * @return String
	 */
	public static String han_kaku_to_zen_kaku_full_symbol_number(String str) {
		try {
			//with alpha-numeric characters, spaces convert to Hankaku
			if (StringUtils.isEmptyOrNull(str)) return "";
			String[] HANKAKU_LETTER = new String[]{"ｳﾞ","ｶﾞ","ｷﾞ","ｸﾞ",
					"ｹﾞ","ｺﾞ","ｻﾞ","ｼﾞ",
					"ｽﾞ","ｾﾞ","ｿﾞ","ﾀﾞ",
					"ﾁﾞ","ﾂﾞ","ﾃﾞ","ﾄﾞ",
					"ﾊﾞ","ﾋﾞ","ﾌﾞ","ﾍﾞ",
					"ﾎﾞ","ﾊﾟ","ﾋﾟ","ﾌﾟ","ﾍﾟ","ﾎﾟ",
					/*with alpha-numeric characters, spaces is Zenkaku characters*/
					"０","１","２","３","４","５","６","７","８","９",
					"Ａ", "Ｂ", "Ｃ", "Ｄ","Ｅ", "Ｆ", 
					"Ｇ", "Ｈ", "Ｉ", "Ｊ", "Ｋ", "Ｌ", "Ｍ", "Ｎ", 
					"Ｏ", "Ｐ", "Ｑ", "Ｒ", "Ｓ", "Ｔ", "Ｕ", "Ｖ", 
					"Ｗ", "Ｘ", "Ｙ", "Ｚ", "ａ", "ｂ", "ｃ",
					"ｄ", "ｅ", "ｆ", "ｇ", "ｈ", "ｉ", "ｊ", "ｋ", "ｌ", "ｍ", "ｎ", "ｏ",
					"ｐ", "ｑ", "ｒ", "ｓ", "ｔ", "ｕ", "ｖ", "ｗ", "ｘ", "ｙ", "ｚ", "　"};
			String[] ZENKAKU_LETTER = new String[]{"ヴ","ガ","ギ","グ",
					"ゲ","ゴ","ザ","ジ",
					"ズ","ゼ","ゾ","ダ",
					"ヂ","ヅ","デ","ド",
					"バ","ビ","ブ","ベ",
					"ボ", "パ", "ピ", "プ", "ペ", "ポ",
					/*with alpha-numeric characters, spaces is Hankaku characters*/
					"0","1","2","3","4","5","6","7","8","9",
					"A", "B", "C", "D",
					"E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
					"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c",
					"d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
					"p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", " " };
			for (int cs = 0; cs < HANKAKU_LETTER.length;cs++) {
				str = str.replaceAll(HANKAKU_LETTER[cs], ZENKAKU_LETTER[cs]);
			}
			HANKAKU_LETTER = new String[]{"ｱ","ｲ","ｳ","ｴ","ｵ",
					"ｶ","ｷ","ｸ","ｹ","ｺ",
					"ｻ","ｼ","ｽ","ｾ","ｿ",
					"ﾀ","ﾁ","ﾂ","ﾃ","ﾄ",
					"ﾅ","ﾆ","ﾇ","ﾈ","ﾉ",
					"ﾊ","ﾋ","ﾌ","ﾍ","ﾎ",
					"ﾏ","ﾐ","ﾑ","ﾒ","ﾓ",
					"ﾔ","ﾕ","ﾖ","ﾗ","ﾘ",
					"ﾙ","ﾚ","ﾛ","ﾜ","ｦ",
					"ﾝ","ｧ","ｨ","ｩ","ｪ",
					"ｫ","ヵ","ヶ","ｬ","ｭ",
					"ｮ","ｯ","､","｡","ｰ",
					"｢","｣","ﾞ","ﾟ"};
			ZENKAKU_LETTER = new String[]{"ア","イ","ウ","エ","オ",
					"カ","キ","ク","ケ","コ",
					"サ","シ","ス","セ","ソ",
					"タ","チ","ツ","テ","ト",
					"ナ","ニ","ヌ","ネ","ノ",
					"ハ","ヒ","フ","ヘ","ホ",
					"マ","ミ","ム","メ","モ",
					"ヤ","ユ","ヨ","ラ","リ",
					"ル","レ","ロ","ワ","ヲ",
					"ン","ァ","ィ","ゥ","ェ",
					"ォ","ヶ","ヶ","ャ","ュ",
					"ョ","ッ","、","。","ー",
					"「","」","”",""};
			for (int cs = 0; cs < HANKAKU_LETTER.length;cs++) {
				str = str.replaceAll(HANKAKU_LETTER[cs], ZENKAKU_LETTER[cs]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * Zenkaku=ゴ
	 * Hankaku=ｺﾞ
	 * @param str
	 * @return String
	 */
	public static String han_kaku_to_zen_kaku_only_japan_symbol(String str) {
		try {
			//with alpha-numeric characters, spaces convert to Hankaku
			if (StringUtils.isEmptyOrNull(str)) return "";
			String[] HANKAKU_LETTER = new String[]{"ｳﾞ","ｶﾞ","ｷﾞ","ｸﾞ",
					"ｹﾞ","ｺﾞ","ｻﾞ","ｼﾞ",
					"ｽﾞ","ｾﾞ","ｿﾞ","ﾀﾞ",
					"ﾁﾞ","ﾂﾞ","ﾃﾞ","ﾄﾞ",
					"ﾊﾞ","ﾋﾞ","ﾌﾞ","ﾍﾞ",
					"ﾎﾞ","ﾊﾟ","ﾋﾟ","ﾌﾟ","ﾍﾟ","ﾎﾟ", "　"};
			String[] ZENKAKU_LETTER = new String[]{"ヴ","ガ","ギ","グ",
					"ゲ","ゴ","ザ","ジ",
					"ズ","ゼ","ゾ","ダ",
					"ヂ","ヅ","デ","ド",
					"バ","ビ","ブ","ベ",
					"ボ", "パ", "ピ", "プ", "ペ", "ポ", " " };
			for (int cs = 0; cs < HANKAKU_LETTER.length;cs++) {
				str = str.replaceAll(HANKAKU_LETTER[cs], ZENKAKU_LETTER[cs]);
			}
			HANKAKU_LETTER = new String[]{"ｱ","ｲ","ｳ","ｴ","ｵ",
					"ｶ","ｷ","ｸ","ｹ","ｺ",
					"ｻ","ｼ","ｽ","ｾ","ｿ",
					"ﾀ","ﾁ","ﾂ","ﾃ","ﾄ",
					"ﾅ","ﾆ","ﾇ","ﾈ","ﾉ",
					"ﾊ","ﾋ","ﾌ","ﾍ","ﾎ",
					"ﾏ","ﾐ","ﾑ","ﾒ","ﾓ",
					"ﾔ","ﾕ","ﾖ","ﾗ","ﾘ",
					"ﾙ","ﾚ","ﾛ","ﾜ","ｦ",
					"ﾝ","ｧ","ｨ","ｩ","ｪ",
					"ｫ","ヵ","ヶ","ｬ","ｭ",
					"ｮ","ｯ","､","｡","ｰ",
					"｢","｣","ﾞ","ﾟ"};
			ZENKAKU_LETTER = new String[]{"ア","イ","ウ","エ","オ",
					"カ","キ","ク","ケ","コ",
					"サ","シ","ス","セ","ソ",
					"タ","チ","ツ","テ","ト",
					"ナ","ニ","ヌ","ネ","ノ",
					"ハ","ヒ","フ","ヘ","ホ",
					"マ","ミ","ム","メ","モ",
					"ヤ","ユ","ヨ","ラ","リ",
					"ル","レ","ロ","ワ","ヲ",
					"ン","ァ","ィ","ゥ","ェ",
					"ォ","ヶ","ヶ","ャ","ュ",
					"ョ","ッ","、","。","ー",
					"「","」","”",""};
			for (int cs = 0; cs < HANKAKU_LETTER.length;cs++) {
				str = str.replaceAll(HANKAKU_LETTER[cs], ZENKAKU_LETTER[cs]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	public static String han_kaku_to_zen_kaku_only_japan_number(String str) {
		try {
			//with alpha-numeric characters, spaces convert to Hankaku
			if (StringUtils.isEmptyOrNull(str)) return "";
			String[] HANKAKU_LETTER = new String[]{
					/*with alpha-numeric characters, spaces is Hankaku characters*/
					"0","1","2","3","4","5","6","7","8","9", " "
					};
			String[] ZENKAKU_LETTER = new String[]{
					/*with alpha-numeric characters, spaces is Zenkaku characters*/
					"０","１","２","３","４","５","６","７","８","９", "　" };
			for (int cs = 0; cs < HANKAKU_LETTER.length;cs++) {
				str = str.replaceAll(HANKAKU_LETTER[cs], ZENKAKU_LETTER[cs]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static String zen_kaku_to_han_kaku_only_japan_number(String str) {
		try {
			if (StringUtils.isEmptyOrNull(str)) return "";
			String[] ZENKAKU_LETTER = new String[]{
					/*with alpha-numeric characters, spaces is Zenkaku characters*/
					"０","１","２","３","４","５","６","７","８","９", "　"
					};
			String[] HANKAKU_LETTER = new String[]{
					/*with alpha-numeric characters, spaces is Hankaku characters*/
					"0","1","2","3","4","5","6","7","8","9", " " };
			for (int cs = 0; cs < ZENKAKU_LETTER.length;cs++) {
				str = str.replaceAll(ZENKAKU_LETTER[cs], HANKAKU_LETTER[cs]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static void main(String[] args) {
		/*for(char ch ='Ａ';ch <='Ｚ';ch++) {
			System.out.print("\"" + ch + "\",");
		}
		for(char ch ='ａ';ch <='ｚ';ch++) {
			System.out.print("\"" + ch + "\",");
		}*/
		/*System.out.println();
		for(char ch ='A';ch <='Z';ch++) {
			System.out.print("\"" + ch + "\",");
		}
		for(char ch ='a';ch <='z';ch++) {
			System.out.print("\"" + ch + "\",");
		}
		System.out.println();*/
		/*for(char ch ='０';ch <='９';ch++) {
			System.out.print("\"" + ch + "\",");
		}
		System.out.println();
		
		for(char ch ='0';ch <='9';ch++) {
			System.out.print("\"" + ch + "\",");
		}
		System.out.println();
		*/
		String han_symbol = "ｱﾘｶﾞﾄｳｺﾞｻﾞｲﾏｽ";
		System.out.println("han_symbol=" + han_symbol);
		//System.out.println("ﾜﾝﾋﾟ=" + han_kaku_to_zen_kaku_full_symbol_number("ﾜﾝﾋﾟ"));
		String zen_symbol_from_han_symbol = han_kaku_to_zen_kaku_full_symbol_number(han_symbol);
		System.out.println("--->"+han_symbol+"=" + zen_symbol_from_han_symbol + "|length=" + zen_symbol_from_han_symbol.length() + "|getBytes().length=" + zen_symbol_from_han_symbol.getBytes().length);
		
		System.out.println("====================================================================================================");
		String mf8Hankaku_mf7Zenkaku = KanaConverter.convertKana(han_symbol, KanaConverter.OP_HAN_KATA_TO_ZEN_KATA | KanaConverter.OP_ZEN_ASCII_TO_HAN_ASCII);
		System.out.println("-----> mf8Hankaku_mf7Zenkaku=" + mf8Hankaku_mf7Zenkaku);
		System.out.println("-----> mf8Hankaku_mf7Zenkaku-->length=" + mf8Hankaku_mf7Zenkaku.length() + "|mf8_mf7.getBytes()-->length=" + mf8Hankaku_mf7Zenkaku.getBytes().length);
		System.out.println("-----> han_symbol.length()="+ han_symbol.length()+"|han_symbol.getBytes().length=" + han_symbol.getBytes().length+"");
		
		
		/*String mf7 = "ゴ";//"あ";//"ﾎﾞ";Zenkaku　ａｒｉｇａｔｏｕ　ｇｏｚａｉｍａｓｕ　＝アリガトウ　ゴザイマス
		String mf8 = "ｺﾞ";//"あ";//"ﾎﾞ";Hankaku　ａｒｉｇａｔｏｕ　ｇｏｚａｉｍａｓｕ　＝ｱﾘｶﾞﾄｳ　ｺﾞｻﾞｲﾏｽ
		
		String zenChk = "ｱﾘｶﾞﾄｳｺﾞｻﾞﾏｽ ＡＲＩＧＡＴＯＵ　ＧＯＺＡＩＭＡＳＵ ａｒｉｇａｔｏｕ　ｇｏｚａｉｍａｓｕロ０１２３４５６７８９";
		String zenConv = han_kaku_to_zen_kaku_full_symbol_number(zenChk);
		System.out.println(zenChk + "=" + zenConv);
		//
		System.out.println("zenChk.length()="+ zenChk.length()+"|getBytes().length=" + zenChk.getBytes().length+"");
		System.out.println("zenConv.length()="+ zenConv.length()+"|getBytes().length=" + zenConv.getBytes().length+"");
		
		//
		String _han_kaku_to_zen_kaku_only_japan_number = han_kaku_to_zen_kaku_only_japan_number("０１２３４５６７８９");
		System.out.print(_han_kaku_to_zen_kaku_only_japan_number);
		System.out.println("-->length=" + _han_kaku_to_zen_kaku_only_japan_number.length());
		System.out.println("０１２３４５６７８９-->length=" + "０１２３４５６７８９".length());*/
	}
	//--------------------------------------------------------//
}
