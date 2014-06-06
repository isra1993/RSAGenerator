package model;

import java.math.BigInteger;
import java.security.SecureRandom;

import rsa.RSA;

public class RSAJava implements RSAInterface {

	@Override
	public String[] getPQ(int rNumber) {
		SecureRandom r = new SecureRandom();
		BigInteger p = new BigInteger(rNumber / 2, 100, r);
		BigInteger q = new BigInteger(rNumber / 2, 100, r);
		return new String[] { p.toString(), q.toString() };
	}

	@Override
	public String[] getEDN(String p, String q) {
		BigInteger pp = new BigInteger(p);
		BigInteger qq = new BigInteger(q);
		BigInteger n = pp.multiply(qq);
		BigInteger e;
		BigInteger d;
		BigInteger m = (pp.subtract(BigInteger.ONE)).multiply(qq
				.subtract(BigInteger.ONE));
		e = new BigInteger("3");
		while (m.gcd(e).intValue() > 1) {
			e = e.add(new BigInteger("2"));
		}
		d = e.modInverse(m);
		int length = (int) (log(n) / log(new BigInteger("255")));
		BigInteger ppp = new BigInteger(pp.toString());
		ppp = ppp.subtract(BigInteger.ONE);
		BigInteger qqq = new BigInteger(qq.toString());
		qqq = ppp.subtract(BigInteger.ONE);
		BigInteger phi = ppp.multiply(qqq);
		return new String[] { length + "", n.toString(), phi.toString(),
				e.toString(), d.toString() };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.RSAInterface#cipherMessage(java.lang.String, java.lang.String,
	 * java.lang.String)
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
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public byte[] decipherMessage(String n, String d, byte[] data) {
		BigInteger nn = new BigInteger(n);
		BigInteger nd = new BigInteger(d);
		return RSA.decrypt(data, nd, nn);
	}

	@Override
	public void init() {
		// Nothing to initialize
	}

	public double log(BigInteger val) {
		// Get the minimum number of bits necessary to hold this value.
		int n = val.bitLength();

		// Calculate the double-precision fraction of this number; as if the
		// binary point was left of the most significant '1' bit.
		// (Get the most significant 53 bits and divide by 2^53)
		long mask = 1L << 52; // mantissa is 53 bits (including hidden bit)
		long mantissa = 0;
		int j = 0;
		for (int i = 1; i < 54; i++) {
			j = n - i;
			if (j < 0)
				break;

			if (val.testBit(j))
				mantissa |= mask;
			mask >>>= 1;
		}
		// Round up if next bit is 1.
		if (j > 0 && val.testBit(j - 1))
			mantissa++;

		double f = mantissa / (double) (1L << 52);

		// Add the logarithm to the number of bits, and subtract 1 because the
		// number of bits is always higher than necessary for a number
		// (ie. log2(val)<n for every val).
		return (n - 1 + Math.log(f) * 1.44269504088896340735992468100189213742664595415298D);
		// Magic number converts from base e to base 2 before adding. For other
		// bases, correct the result, NOT this number!
	}

}
