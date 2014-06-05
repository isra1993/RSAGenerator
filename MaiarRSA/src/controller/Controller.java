package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import model.RSAInterface;
import view.Window;

public class Controller implements ActionListener {

	private Window window;
	private RSAInterface generator;
	private static final int DEFAULT_R_LENGTH = 10;
	private int maxMsgLength;
	private boolean encrypt;

	public Controller(Window window, RSAInterface generator) {
		this.window = window;
		this.generator = generator;
		this.encrypt = true;
		this.maxMsgLength = 0;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == window.getPrimesButton()) {
			String[] fields = this.generator.getPQ(DEFAULT_R_LENGTH);
			window.setpField(fields[0]);
			window.setqField(fields[1]);
			System.out.println(Arrays.toString(fields));
			window.setDataButtonEnabled(true);
		} else if (event.getSource() == window.getDataButton()) {
			String[] fields = this.generator.getEDN(window.getP(),
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
				window.setProcessedField(this.generator.cipherMessage(
						window.getN(), window.getE(), msg, maxMsgLength));
			} else {
				window.setProcessedField("");
				System.out.println(msg);
				String txt = this.generator.decipherMessage(window.getN(),
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
