package model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

public class RSAController {

	private RSAInterface algorithm;

	public RSAController(RSAInterface algorithm) {
		this.algorithm = algorithm;
	}

	public void setAlgorithm(RSAInterface algorithm) {
		this.algorithm = algorithm;
		this.initAlgorithm();
	}

	public void initAlgorithm() {
		this.algorithm.init();
	}

	public String cipherMessage(String n, String e, String msg, int maxLength) {
		String[] chunks = split(msg, maxLength);
		List<Byte> bytes = new ArrayList<Byte>();
		for (String chunk : chunks) {
			byte[] buff = algorithm.cipherMessage(n, e, chunk);
			for (Byte b : buff) {
				bytes.add(b);
			}
		}
		Byte[] result = new Byte[bytes.size()];
		bytes.toArray(result);
		int index = 0;
		byte[] resultInBytes = new byte[result.length];
		for (Byte actual : result) {
			resultInBytes[index++] = actual.byteValue();
		}
		return new String(Base64.encodeBase64(resultInBytes));
	}

	public String decipherMessage(String n, String d, String msg, int maxLength) {
		byte[] binaryData = Base64.decodeBase64(msg.getBytes());
		byte[][] chunks = divideArray(binaryData, maxLength + 1);

		List<Byte> bytes = new ArrayList<Byte>();
		for (byte[] chunk : chunks) {
			byte[] buff = algorithm.decipherMessage(n, d, chunk);
			for (Byte b : buff) {
				bytes.add(b);
			}
		}
		Byte[] result = new Byte[bytes.size()];
		bytes.toArray(result);
		int index = 0;
		byte[] resultInBytes = new byte[result.length];
		for (Byte actual : result) {
			resultInBytes[index++] = actual.byteValue();
		}
		return new String(resultInBytes);
	}

	public static String[] split(String s, int n) {
		return s.split("(?<=\\G(.{" + n + "}))");
	}

	public String[] getPQ(int rNumber) {
		return algorithm.getPQ(rNumber);
	}

	public String[] getEDN(String p, String q) {
		return algorithm.getEDN(p, q);
	}

	public static byte[][] divideArray(byte[] source, int chunksize) {

		byte[][] ret = new byte[(int) Math.ceil(source.length
				/ (double) chunksize)][chunksize];

		int start = 0;

		for (int i = 0; i < ret.length; i++) {
			if (start + chunksize > source.length) {
				System.arraycopy(source, start, ret[i], 0, source.length
						- start);
			} else {
				System.arraycopy(source, start, ret[i], 0, chunksize);
			}
			start += chunksize;
		}

		return ret;
	}
}
