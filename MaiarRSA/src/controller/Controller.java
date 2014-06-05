package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import model.RSAInterface;
import view.Window;

public class Controller implements ActionListener {

	private Window window;
	private RSAInterface rsa;
	private static final int DEFAULT_R_LENGTH = 10;
	private int maxMsgLength;
	private boolean encrypt;
	private boolean initRSAAlgorithm;

	public Controller(Window window, RSAInterface rsa) {
		this.window = window;
		this.rsa = rsa;
		this.encrypt = true;
		this.maxMsgLength = 0;
		this.initRSAAlgorithm = false;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(!this.initRSAAlgorithm) {
			this.initRSAAlgorithm = true;
			this.rsa.init();
		}
		if (event.getSource() == window.getPrimesButton()) {
			String[] fields = this.rsa.getPQ(DEFAULT_R_LENGTH);
			window.setpField(fields[0]);
			window.setqField(fields[1]);
			System.out.println(Arrays.toString(fields));
			window.setDataButtonEnabled(true);
		} else if (event.getSource() == window.getDataButton()) {
			String[] fields = this.rsa.getEDN(window.getP(),
					window.getQ());
			this.maxMsgLength = (int) Double.parseDouble(fields[0]);
			System.out.println(this.maxMsgLength);
			window.setnField(fields[1]);
			window.setPhiField(fields[2]);
			window.seteField(fields[3]);
			window.setdField(fields[4]);
			window.setMessageButtonEnabled(true);
		} else if (event.getSource() == window.getMessageButton()) {
			String msg = window.getWrittenMessage();
			if (this.encrypt) {
				window.setProcessedField(this.rsa.cipherMessage(
						window.getN(), window.getE(), msg, maxMsgLength));
			} else {
				window.setProcessedField("");
				System.out.println(msg);
				String txt = this.rsa.decipherMessage(window.getN(),
						window.getD(), msg, maxMsgLength);
				window.setProcessedField(txt);
			}
		} else if (event.getSource() == window.getClearButton()) {
			clearAll();
		} else if (event.getSource() == window.getInvertRol()) {
			this.encrypt = !this.encrypt;
		}
	}

	private void clearAll() {
		window.setpField("");
		window.setqField("");
		window.setnField("");
		window.setPhiField("");
		window.seteField("");
		window.setdField("");
		window.setWrittenField("");
		window.setProcessedField("");
		window.setDataButtonEnabled(false);
		window.setMessageButtonEnabled(false);
	}
}
