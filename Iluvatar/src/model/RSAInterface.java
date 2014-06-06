package model;

public interface RSAInterface {

	public abstract String[] getPQ(int rNumber);

	public abstract String[] getEDN(String p, String q);

	public abstract byte[] cipherMessage(String n, String e, String msg);

	public abstract byte[] decipherMessage(String n, String d, byte[] msg);

	public void init();

}