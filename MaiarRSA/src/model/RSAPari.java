package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;

import org.freemonad.paridroid.PariNative;

import rsa.RSA;

public class RSAPari implements RSAInterface {

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.RSAInterface#getPQ(int)
	 */
	@Override
	public String[] getPQ(int rNumber) {
		String s = PariNative.paridroidEval("calculatePQ(" + rNumber + ")");
		String ss = s.substring(s.lastIndexOf("[") + 1, s.lastIndexOf("]"))
				.replace(" ", "");
		return ss.split(",");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.RSAInterface#getEDN(java.lang.String, java.lang.String)
	 */
	@Override
	public String[] getEDN(String p, String q) {
		String s = PariNative.paridroidEval("calculateED(" + p + "," + q
				+ ",20,255)");
		String ss = s.substring(s.lastIndexOf("[") + 1, s.lastIndexOf("]"))
				.replace(" ", "");
		;
		return ss.split(",");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.RSAInterface#cipherMessage(java.lang.String, java.lang.String,
	 * java.lang.String, int)
	 */
	@Override
	public byte[] cipherMessage(String n, String e, String msg) {
		BigInteger nn = new BigInteger(n);
		BigInteger ne = new BigInteger(e);
		return RSA.encrypt(msg, ne, nn);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.RSAInterface#decipherMessage(java.lang.String,
	 * java.lang.String, java.lang.String, int)
	 */
	@Override
	public byte[] decipherMessage(String n, String d, byte[] data) {
		BigInteger nn = new BigInteger(n);
		BigInteger nd = new BigInteger(d);
		return RSA.decrypt(data, nd, nn);
	}

	@Override
	public void init() {
		PariNative.paridroidInit();
		try {
			PariNative.loadLibray(new File("").getAbsolutePath() + "/pari.gp");
		} catch (FileNotFoundException e) {
			System.err.println("Cannot load pari library");
			System.exit(-1);
		}
	}
}
