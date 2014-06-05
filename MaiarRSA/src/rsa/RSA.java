package rsa;

import java.math.BigInteger;

import org.apache.commons.codec.binary.Base64;

public class RSA {

	public static String encrypt(String message64, BigInteger e, BigInteger N) {

		byte[] buffer = (new BigInteger(message64.getBytes())).modPow(e, N)
				.toByteArray();
		return new String(Base64.encodeBase64(buffer));
	}

	public static String decrypt(String message64, BigInteger d, BigInteger N) {
		byte[] buff = Base64.decodeBase64(message64);
		return new String((new BigInteger(buff)).modPow(d, N).toByteArray());
	}

	public BigInteger[] generatePQ(int rlength) {
		return null;
	}

	public BigInteger[] generateED(BigInteger p, BigInteger d) {
		return null;
	}
}