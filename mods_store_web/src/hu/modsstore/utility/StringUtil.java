package hu.modsstore.utility;

public class StringUtil {
	
	private StringUtil() {
		
	}
	
	public static String replace(String str) {
		return str.replaceAll("\u0151", "&#337").replaceAll("\u0171", "&#369")
			.replaceAll("\u0150", "&#336").replaceAll("\u0170", "&#368");
	}
	
	public static String replaceBack(String str) {
		return str.replaceAll("&#337", "o").replaceAll("&#369", "u")
			.replaceAll("&#336", "O").replaceAll("&#368", "U");
	}
	
	public static String removeAcutes(String str) {
		return str.replace('\u00f6', 'o').replace('\u00fc', 'u')
		.replace('\u00f3', 'o').replace('\u0151', 'o')
		.replace('\u00fa', 'u').replace('\u00e9', 'e')
		.replace('\u00e1', 'a').replace('\u0171', 'u')
		.replace('\u00ed', 'i')
		.replace('\u00d6', 'O').replace('\u00dc', 'U')
		.replace('\u00d3', 'O').replace('\u0150', 'O')
		.replace('\u00da', 'U').replace('\u00c9', 'E')
		.replace('\u00c1', 'A').replace('\u0170', 'U')
		.replace('\u00cd', 'I');
	}

}
