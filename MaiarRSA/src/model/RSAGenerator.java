package model;

import org.freemonad.paridroid.PariNative;

public class RSAGenerator {


	public String[] getNumbers(int rNumber) {
		String s = PariNative.paridroidEval("generateRSAPair(10,10,10)");
		String ss = s.substring(s.lastIndexOf("[")+1, s.lastIndexOf("]"));
		return ss.split(",");
	}
}
