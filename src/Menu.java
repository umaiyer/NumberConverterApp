import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Menu implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton binToDec = new JButton();
	JButton binToHex = new JButton();
	JButton decToBin = new JButton();
	JButton decToHex = new JButton();
	JButton hexToBin = new JButton();
	JButton hexToDec = new JButton();
	
	public void createUI() {
		
		frame.setVisible(true);
		frame.setTitle("Number Systems");
		
		frame.add(panel);
		panel.add(binToDec);
		panel.add(binToHex);
		panel.add(decToBin);
		panel.add(decToHex);
		panel.add(hexToBin);
		panel.add(hexToDec);
		
		// Set button text
		binToDec.setText("Bin To Dec");
		binToHex.setText("Bin To Hex");
		decToBin.setText("Dec to Bin");
		decToHex.setText("Dec to Hex");
		hexToBin.setText("Hex to Bin");
		hexToDec.setText("Hex to Dec");
		
		//Add listeners
		binToDec.addActionListener(this);
		binToHex.addActionListener(this);
		decToBin.addActionListener(this);
		decToHex.addActionListener(this);
		hexToBin.addActionListener(this);
		hexToDec.addActionListener(this);
		
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == binToDec) {
			String binaryInput = JOptionPane.showInputDialog("Enter Binary Number");
			if (binaryInput.length() > 32) { 
				JOptionPane.showMessageDialog(null, "ERROR: Max supported length for binary string is 32");
				return;
			}
			
			try {
				int integerOutput = new Binary().convertToDecimal(binaryInput);
				JOptionPane.showMessageDialog(null,"Binary " + binaryInput + " converted to Decimal " + integerOutput);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "ERROR: " + binaryInput + " is not a valid binary number");
			}
			
		}
		else if (e.getSource() == binToHex) {
			String binaryInput = JOptionPane.showInputDialog("Enter Binary Number");
			if (binaryInput.length() > 32) { 
				JOptionPane.showMessageDialog(null, "ERROR: Max supported length for binary string is 32");
				return;
			}
			
			try {
				String hexOut = new Binary().convertToHexadecimal(binaryInput);
				JOptionPane.showMessageDialog(null,"Binary " + binaryInput + " converted to Hexadecimal " + hexOut);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "ERROR: " + binaryInput + " is not a valid binary number");
			}
			
		} else
			System.out.println("Not Bin To Dec");
	}
}
