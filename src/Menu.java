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
		NumberType inputType = NumberType.Unsupported;
		NumberType outputType = NumberType.Unsupported;
		if (e.getSource() == binToDec)
		{
			inputType = NumberType.Binary;
			outputType = NumberType.Decimal;
		} 
		else if (e.getSource() == binToHex) 
		{
			inputType = NumberType.Binary;
			outputType = NumberType.Hexadecimal;
		} 
		else if (e.getSource() == decToBin) 
		{
			inputType = NumberType.Decimal;
			outputType = NumberType.Binary;
		}
		else if ( e.getSource() == decToHex)
		{
			inputType = NumberType.Decimal;
			outputType = NumberType.Hexadecimal;
		} 
		else if (e.getSource() == hexToBin)
		{
			inputType = NumberType.Hexadecimal;
			outputType = NumberType.Binary;
		}
		else if (e.getSource() == hexToDec)
		{
			inputType = NumberType.Hexadecimal;
			outputType = NumberType.Decimal;
		} 
		else 
			inputType = NumberType.Unsupported;
		
		switch (inputType) {
			case Binary:
				
				String binaryInput = JOptionPane.showInputDialog("Enter Binary Number");
				if (binaryInput.length() > 32) { 
					JOptionPane.showMessageDialog(null, "ERROR: Max supported length for binary string is 32");
					return;
				}
				
				try {
					if (outputType == NumberType.Decimal) {
						int integerOutput = new Binary().convertToDecimal(binaryInput);
						JOptionPane.showMessageDialog(null,"Binary " + binaryInput + " converted to Decimal " + integerOutput);
					} else {						
						String hexOut = new Binary().convertToHexadecimal(binaryInput);
						JOptionPane.showMessageDialog(null,"Binary " + binaryInput + " converted to Hexadecimal " + hexOut);
					}					
						
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERROR: " + binaryInput + " is not a valid binary number");
				}

				break;
				
			case Decimal:
			{	
				String inputStr = JOptionPane.showInputDialog("Enter Decimal Number");
				try {
					int decInput = Integer.parseInt(inputStr);
					
					if (outputType == NumberType.Binary) {
						String binOut = new Decimal().convertToBinary(decInput);
						JOptionPane.showMessageDialog(null,"Decimal " + decInput + " converted to Binary " + binOut);
					} else {					
						String hexOut = new Decimal().convertToHexadecimal(decInput);
						JOptionPane.showMessageDialog(null,"Decimal " + decInput + " converted to Hex " + hexOut);
					}
					
				} catch (Exception parseExc) {
					JOptionPane.showMessageDialog(null, "ERROR: " + inputStr + " is not a valid integer");
				} 

				break;
			}	
			case Hexadecimal:
			{
				String inputStr = JOptionPane.showInputDialog("Enter Hexadecimal Number");
				
				if (inputStr.length() > 8) { 
					JOptionPane.showMessageDialog(null, "ERROR: Max supported length for string is 8");
					return;
				}
				
				try {
					
					if (outputType == NumberType.Decimal) {
						int intOut = new Hexadecimal(outputType).convertToDecimal(inputStr.toUpperCase());
						JOptionPane.showMessageDialog(null,"Hexadecimal " + inputStr + " converted to Decimal " + intOut);
					} else {					
						String binOut = new Hexadecimal(outputType).convertToBinary(inputStr.toUpperCase());
						JOptionPane.showMessageDialog(null,"Hexadecimal " + inputStr + " converted to Binary " + binOut);
					}
					
				} catch (Exception parseExc) {
					JOptionPane.showMessageDialog(null, "ERROR: " + inputStr + " is not a valid Hexadecimal");
				}
				
				break;
			}
			case Unsupported:
				System.out.println("Not Bin To Dec");
						
		} // end case
		
	}
}
