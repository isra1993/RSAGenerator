package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

import org.freemonad.paridroid.PariNative;

import model.RSAGenerator;
import view.Window;

public class Controller implements ActionListener {

	private Window window;
	private RSAGenerator generator;
	private boolean isPariInit;
	private static final int DEFAULT_R_LENGTH = 10;
	private int maxMsgLength;

	public Controller(Window window, RSAGenerator generator) {
		this.window = window;
		this.generator = generator;
		this.isPariInit = false;
		this.maxMsgLength = 0;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (!this.isPariInit) {
			this.isPariInit = true;
			PariNative.paridroidInit();
			try {
				PariNative.loadLibray(new File("").getAbsolutePath()
						+ "/pari.gp");
			} catch (FileNotFoundException e) {
				System.err.println("Cannot load pari library");
				System.exit(-1);
			}
		}
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
			System.out.println(msg);
			window.setProcessedField(this.generator.cipherMessage(
					window.getN(), window.getE(), msg, maxMsgLength));
		} else if (event.getSource() == window.getClearButton()) {
			clearAll();
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
