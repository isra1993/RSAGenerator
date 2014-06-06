package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
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

	public Controller(Window window, RSAController rsa) {
		this.window = window;
		this.rsa = rsa;
		this.encrypt = true;
		this.maxMsgLength = 0;
		this.initRSAAlgorithm = false;
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
			saveGeneratedData();
		} else if (event.getSource() == window.getAbout()) {
			JOptionPane
					.showMessageDialog(
							window,
							"Name: Maiar RSA Generator \nAuthors: \n\t\t\t\t\tRuben Rodriguez Fernandez \n\t\t\t\tIsrael Garcia Centeno \n\t\t\t\tJesus Liebana Losada \n\t\t\t\tCarlos Mayo de Prado \nVersion: Beta 2",
							"About", JOptionPane.PLAIN_MESSAGE);
		}
	}

	private void saveGeneratedData() {
		JFileChooser fc = new JFileChooser();
		int option = fc.showSaveDialog(window);
		
		if (option == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			StringBuffer result = new StringBuffer();
			result.append("\tRSA Data Result\n\n");
			result.append("p: \t" + window.getP() + "\n");
			result.append("q: \t" + window.getQ() + "\n");
			result.append("n: \t" + window.getN() + "\n");
			result.append("phi: \t" + window.getPhi() + "\n");
			result.append("e: \t" + window.getE() + "\n");
			result.append("d: \t" + window.getD() + "\n");
			if (encrypt) {
				result.append("Method: ENCRIPT\n");
			} else {
				result.append("Method: DECRIPT\n");
			}
			result.append("message: " + window.getWrittenMessage() + "\t");
			result.append("Processed message: " + window.getProcessedMessage());
			try {
				PrintWriter writer = new PrintWriter(file);
				writer.write(result.toString());
				writer.close();
			} catch (FileNotFoundException e) {
				System.err.println("File not found.");
			}
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
