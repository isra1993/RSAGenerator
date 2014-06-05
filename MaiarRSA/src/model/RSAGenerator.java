package model;

import java.util.Arrays;

import org.freemonad.paridroid.PariNative;

public class RSAGenerator {

	public String[] getPQ(int rNumber) {
		String s = PariNative.paridroidEval("calculatePQ(" + rNumber + ")");
		System.out.println(s);
		String ss = s.substring(s.lastIndexOf("[") + 1, s.lastIndexOf("]"));
		return ss.split(",");
	}

	public String[] getEDN(String p, String q) {
		String s = PariNative.paridroidEval("calculateED(" + p + "," + q
				+ ",3)");
		System.out.println(s);
		String ss = s.substring(s.lastIndexOf("[") + 1, s.lastIndexOf("]"));
		return ss.split(",");
	}

	public String cipherMessage(String n, String e, String msg, int maxLength) {
		// .split("�");
		String result = "";
		// for (String actual : chunks) {
		// // System.out.println(actual);
		// // System.out.println(actual.length());
		// if (actual.length() != maxLength) {
		// for (int i = 0; i < (maxLength - actual.length()); i++) {
		// actual += "-";
		// }
		// }
		result += cipherText(n, e, msg);
		// }
		return result;
	}

	public static String[] splitByLength(String s, int chunkSize) {
		int arraySize = (int) Math.ceil(s.length() / chunkSize);

		String[] returnArray = new String[arraySize];

		int index = 0;
		for (int i = 0; i < s.length(); i = i + chunkSize) {
			if (s.length() - i < chunkSize) {
				returnArray[index++] = s.substring(i);
			} else {
				returnArray[index++] = s.substring(i, i + chunkSize);
			}
		}

		return returnArray;
	}

	private String cipherText(String n, String e, String msg) {
		String cipher = PariNative.paridroidEval("cifrarRSA(\"" + msg + "\","
				+ n + "," + e + ")");
		return cipher.replace("\"", "");
	}
}
