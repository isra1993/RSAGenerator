package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.RSAController;
import model.RSAJava;
import model.RSAPari;
import view.Window;

public class Controller implements ActionListener {

	private Window window;
	private RSAController rsa;
	private int maxMsgLength;
	private boolean encrypt;
	private boolean initRSAAlgorithm;
	private boolean java;

	public Controller(Window window, RSAController rsa) {
		this.window = window;
		this.rsa = rsa;
		this.encrypt = true;
		this.maxMsgLength = 0;
		this.initRSAAlgorithm = false;
		this.java = true;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (!this.initRSAAlgorithm) {
			this.initRSAAlgorithm = true;
			this.rsa.initAlgorithm();
		}
		if (event.getSource() == window.getPrimesButton()) {
			String[] fields = this.rsa.getPQ(Integer.parseInt(window.getR()));
			window.setpField(fields[0]);
			window.setqField(fields[1]);
			window.setDataButtonEnabled(true);
		} else if (event.getSource() == window.getDataButton()) {
			String[] fields = this.rsa.getEDN(window.getP(), window.getQ());
			this.maxMsgLength = (int) Double.parseDouble(fields[0]);
			window.setnField(fields[1]);
			window.setPhiField(fields[2]);
			window.seteField(fields[3]);
			window.setdField(fields[4]);
			window.setMessageButtonEnabled(true);
		} else if (event.getSource() == window.getMessageButton()) {
			String msg = window.getWrittenMessage();
			if (this.encrypt) {
				window.setProcessedField(this.rsa.cipherMessage(window.getN(),
						window.getE(), msg, maxMsgLength));
			} else {
				window.setProcessedField("");
				String txt = this.rsa.decipherMessage(window.getN(),
						window.getD(), msg, maxMsgLength);
				window.setProcessedField(txt);
			}
		} else if (event.getSource() == window.getClearButton()) {
			clearAll();
		} else if (event.getSource() == window.getInvertRol()) {
			this.encrypt = !this.encrypt;
			this.window.setEncript();
		} else if (event.getSource() == window.getJava()) {
			this.rsa.setAlgorithm(new RSAJava());
		} else if (event.getSource() == window.getPari()) {
			this.rsa.setAlgorithm(new RSAPari());
		} else if (event.getSource() == window.getSaveInFile()) {

		} else if (event.getSource() == window.getAbout()) {
			JOptionPane
					.showMessageDialog(
							window,
							"Name: Maiar RSA Generator \nAuthors: \n\t\t\t\t\tRuben Rodriguez Fernandez \n\t\t\t\tIsrael Garcia Centeno \n\t\t\t\tJesus Liebana Losada \n\t\t\t\tCarlos Mayo de Prado \nVersion: Beta 2",
							"About", JOptionPane.PLAIN_MESSAGE);
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
		window.setrField("");
		window.setDataButtonEnabled(false);
		window.setMessageButtonEnabled(false);
	}
}
