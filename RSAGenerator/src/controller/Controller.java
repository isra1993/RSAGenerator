package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.RSAGenerator;
import view.Window;

public class Controller implements ActionListener {
	
	private Window window;
	private RSAGenerator generator;
	
	public Controller(Window window, RSAGenerator generator) {
		this.window = window;
		this.generator = generator;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == window.getPrimesButton()) {
			window.setDataButtonEnabled(true);
		} else if (event.getSource() == window.getDataButton()) {
			window.setMessageButtonEnabled(true);
		} else if (event.getSource() == window.getMessageButton()) {
			
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
