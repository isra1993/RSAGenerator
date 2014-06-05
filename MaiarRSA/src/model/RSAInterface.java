package model;

public interface RSAInterface {

	public abstract String[] getPQ(int rNumber);

	public abstract String[] getEDN(String p, String q);

	public abstract String cipherMessage(String n, String e, String msg,
			int maxLength);

	public abstract String decipherMessage(String n, String d, String msg,
			int maxLength);

	public void init();

}