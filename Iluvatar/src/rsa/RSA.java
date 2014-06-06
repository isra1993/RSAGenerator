package rsa;

import java.math.BigInteger;

public class RSA {

	public static byte[] encrypt(String message64, BigInteger e, BigInteger N) {
		byte[] buffer = (new BigInteger(message64.getBytes())).modPow(e, N)
				.toByteArray();
		return buffer;
	}

	public static byte[] decrypt(byte [] buff, BigInteger d, BigInteger N) {
		return (new BigInteger(buff)).modPow(d, N).toByteArray();
	}

	public BigInteger[] generatePQ(int rlength) {
		return null;
	}

	public BigInteger[] generateED(BigInteger p, BigInteger d) {
		return null;
	}
}