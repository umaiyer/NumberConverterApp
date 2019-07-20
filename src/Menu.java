// GUI class that is the main entry point for providing 
// the user with the options to convert different number types

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
	
	// Stores the current input and output number type selected by the user
	NumberType inputType;
	NumberType outputType;
	
	
	/*
	 * Create input main menu
	 */
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
		
		// Process input event and set input and output number types
		updateNumberTypes((JButton) (e.getSource()));
		
		// Process input number type and call corresponding conversion class
		switch (inputType) {
			case Binary:				
				processBinary();
				break;
				
			case Decimal:
			{	
				processDecimal();
				break;
			}	
			case Hexadecimal:
			{
				processHexadecimal();
				break;
			}
			case Unsupported:
				JOptionPane.showMessageDialog(null, "ERROR: " + " Unsupported Conversion");
						
		} // end case
		
	}
	
	
	// Sets/updates the current input and output conversion types selected by the user	
	private void updateNumberTypes(JButton button) {
		inputType = NumberType.Unsupported;
		outputType = NumberType.Unsupported;
		if (button == binToDec)
		{
			inputType = NumberType.Binary;
			outputType = NumberType.Decimal;
		} 
		else if (button == binToHex) 
		{
			inputType = NumberType.Binary;
			outputType = NumberType.Hexadecimal;
		} 
		else if (button == decToBin) 
		{
			inputType = NumberType.Decimal;
			outputType = NumberType.Binary;
		}
		else if ( button == decToHex)
		{
			inputType = NumberType.Decimal;
			outputType = NumberType.Hexadecimal;
		} 
		else if ( button == hexToBin)
		{
			inputType = NumberType.Hexadecimal;
			outputType = NumberType.Binary;
		}
		else if ( button  == hexToDec)
		{
			inputType = NumberType.Hexadecimal;
			outputType = NumberType.Decimal;
		} 
		else 
			inputType = NumberType.Unsupported;		
	} // end setConversionTypes
	
	
	// Process binary input
	private void processBinary() {
		// Get input binary string
		String binaryInput = JOptionPane.showInputDialog("Enter Binary Number");
		
		// Strings greater than 32 chars not supported
		if (binaryInput.length() > 32) { 
			JOptionPane.showMessageDialog(null, "ERROR: Max supported length for binary string is 32");
			return;
		}
		
		// Create Binary object instance
		Binary binary = new Binary();
		
		// Call number converter method based on output type 
		try {
			if (outputType == NumberType.Decimal) {
				int integerOutput = binary.convertToDecimal(binaryInput);
				JOptionPane.showMessageDialog(null,"Binary " + binaryInput + " converted to Decimal " + integerOutput);
			} else {						
				String hexOut = binary.convertToHexadecimal(binaryInput);
				JOptionPane.showMessageDialog(null,"Binary " + binaryInput + " converted to Hexadecimal " + hexOut);
			}					
				
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "ERROR: Invalid binary " + binaryInput);
		}
		
	}
	
	
	// Process Decimal input
	private void processDecimal() {
		// Get input decimal and parse
		String inputStr = JOptionPane.showInputDialog("Enter Decimal Number");
		try {
			int decInput = Integer.parseInt(inputStr);
			
			Decimal decimal = new Decimal();
			
			// Call number converter method based on output type 
			if (outputType == NumberType.Binary) {
				String binOut = decimal.convertToBinary(decInput);
				JOptionPane.showMessageDialog(null,"Decimal " + decInput + " converted to Binary " + binOut);
			} else {					
				String hexOut = decimal.convertToHexadecimal(decInput);
				JOptionPane.showMessageDialog(null,"Decimal " + decInput + " converted to Hex " + hexOut);
			}
			
		} catch (Exception parseExc) {
			JOptionPane.showMessageDialog(null, "ERROR: Invalid Decimal " + inputStr);
		} 

		
	}
	
	// Process hexadecimal input
	private void processHexadecimal() {
		// Get input Hexadecimal string
		String inputStr = JOptionPane.showInputDialog("Enter Hexadecimal Number");
		
		// Max supported hex string length is 8
		if (inputStr.length() > 8) { 
			JOptionPane.showMessageDialog(null, "ERROR: Max supported length for string is 8");
			return;
		}
		
		// Create hexadecimal object instance
		try {
			Hexadecimal hex = new Hexadecimal(outputType);
		
			// Call number converted method based on the output type									
			if (outputType == NumberType.Decimal) {
				int intOut = hex.convertToDecimal(inputStr.toUpperCase());
				JOptionPane.showMessageDialog(null,"Hexadecimal " + inputStr + " converted to Decimal " + intOut);
			} else {					
				String binOut = hex.convertToBinary(inputStr.toUpperCase());
				JOptionPane.showMessageDialog(null,"Hexadecimal " + inputStr + " converted to Binary " + binOut);
			}
			
		} catch (Exception parseExc) {
			JOptionPane.showMessageDialog(null, "ERROR: Invalid Hexadecimal " + inputStr);
		}
		

	}
}
