package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import model.RSAController;
import model.RSAInterface;

import view.Window;

public class Controller implements ActionListener {

	private Window window;
	private RSAController rsa;
	private int maxLength;
	private boolean invert;

	public Controller(Window window, RSAInterface rsa) {
		this.window = window;
		this.rsa = new RSAController(rsa);
		this.invert = false;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == window.getGenerateA()) {
			if (maxLength == 0) {
				String[] pq = this.rsa.getPQ(2);
				String[] mned = this.rsa.getEDN(pq[0], pq[1]);
				this.maxLength = Integer.parseInt(mned[0]);
				this.window.setNaField(mned[1]);
				this.window.setEaField(mned[3]);
				this.window.setDaField(mned[4]);
			} else {
				int localLength = 0;
				String[] pq = null;
				String[] mned = null;
				while (localLength != maxLength) {
					pq = this.rsa.getPQ(2);
					mned = this.rsa.getEDN(pq[0], pq[1]);
					localLength = Integer.parseInt(mned[0]);
				}
				this.window.setNaField(mned[1]);
				this.window.setEaField(mned[3]);
				this.window.setDaField(mned[4]);
			}
		} else if (event.getSource() == window.getGenerateB()) {
			if (maxLength == 0) {
				String[] pq = this.rsa.getPQ(2);
				String[] mned = this.rsa.getEDN(pq[0], pq[1]);
				this.maxLength = Integer.parseInt(mned[0]);
				this.window.setNbField(mned[1]);
				this.window.setEbField(mned[3]);
				this.window.setDbField(mned[4]);
			} else {
				int localLength = 0;
				String[] pq = null;
				String[] mned = null;
				while (localLength != maxLength) {
					pq = this.rsa.getPQ(2);
					mned = this.rsa.getEDN(pq[0], pq[1]);
					localLength = Integer.parseInt(mned[0]);
				}
				this.window.setNbField(mned[1]);
				this.window.setEbField(mned[3]);
				this.window.setDbField(mned[4]);
			}

		} else if (event.getSource() == window.getSign()) {
			if (!window.getaMessage().equals("") && !this.invert) {
				String na = this.window.getNa();
				String da = this.window.getDa();
				String nb = this.window.getNb();
				String eb = this.window.getEb();
				String msg = this.window.getaMessage();
				String message = this.rsa.cipherMessage(nb, eb, msg, maxLength);
				String sign = this.rsa.cipherMessage(na, da, msg, maxLength);
				this.window.setbMessage(message);
				this.window.setbSignedMessage(sign);
			} 
			
			if (!window.getaMessage().equals("") && this.invert) {
				String na = this.window.getNa();
				String ea = this.window.getEa();
				String nb = this.window.getNb();
				String db = this.window.getDb();
				String msg = this.window.getaMessage();
				String message = this.rsa.cipherMessage(na, ea, msg, maxLength);
				String sign = this.rsa.cipherMessage(nb, db, msg, maxLength);
				this.window.setbMessage(message);
				this.window.setbSignedMessage(sign);
			}
		} else if (event.getSource() == window.getVerifySign()) {
			if (!this.invert) {
				if (!window.getbSignedMessage().equals("")
						&& !window.getbSignedMessage().equals("")) {
					String na = this.window.getNa();
					String ea = this.window.getEa();
					String nb = this.window.getNb();
					String db = this.window.getDb();
					String msg = this.window.getbMessage();
					String sign = this.window.getbSignedMessage();
					msg = this.rsa.decipherMessage(nb, db, msg, maxLength);
					sign = this.rsa.decipherMessage(na, ea, sign, maxLength);
					this.window.setbMessage(msg);
					if (Arrays.equals(sign.getBytes(), msg.getBytes())) {
						this.window.setbSignedMessage("SIGNATURE OK");
					} else {
						this.window.setbSignedMessage("SIGNATURE FAIL!!");
					}
				}
			} else {
				if (!window.getbSignedMessage().equals("")
						&& !window.getbSignedMessage().equals("")) {
					String na = this.window.getNa();
					String da = this.window.getDa();
					String nb = this.window.getNb();
					String eb = this.window.getEb();
					String msg = this.window.getbMessage();
					String sign = this.window.getbSignedMessage();
					msg = this.rsa.decipherMessage(na, da, msg, maxLength);
					sign = this.rsa.decipherMessage(nb, eb, sign, maxLength);
					this.window.setbMessage(msg);
					if (msg.equals(sign)) {
						this.window.setbSignedMessage("SIGNATURE OK");
					} else {
						this.window.setbSignedMessage("SIGNATURE FAIL!!");
					}
				}
			}
		} else if (event.getSource() == window.getInvertRol()) {
			this.invert = !this.invert;
			this.window.setInvert();
		} else if (event.getSource() == window.getClear()) {
			clearFields();
		}
	}

	private void clearFields() {
		this.window.setNaField("");
		this.window.setEaField("");
		this.window.setDaField("");
		this.window.setNbField("");
		this.window.setEbField("");
		this.window.setDbField("");
		this.window.setaMessage("");
		this.window.setbMessage("");
		this.window.setbSignedMessage("");
	}

}
