package org.freemonad.paridroid;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PariNative {

	static {
		try {
			System.load(new File("").getAbsolutePath() + "/pari.so");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/* JNI CALLBACK DECLARATIONS */

	/**
	 * Declaration of JNI callback to paridroid_init().
	 */
	public static native void paridroidInit();

	/**
	 * Declaration of JNI callback to paridroid_eval().
	 * 
	 * @param cmd
	 *            : The GP command to run.
	 * @return Output from GP interpreter.
	 */
	public static native String paridroidEval(String cmd);

	public static boolean loadLibray(String path) throws FileNotFoundException {
		File f = new File(path);
		String s = "";
		Scanner sc = new Scanner(f);
		while(sc.hasNext()) {
			s += sc.nextLine()+"\n";
		}
		paridroidEval(s);
		return true;
	}

	public static native int getHistSize();
}
