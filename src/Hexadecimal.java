import java.util.HashMap;

// This class is used to convert hexadecimal numbers to binary and decimal numbers
public class Hexadecimal {
	
	// Mapping from hex characters
	HashMap<Character, Integer> hexToDec;
	HashMap<Character, String> hexToBin;
	
	// 
	public Hexadecimal(NumberType outputType) throws Exception {
		if (outputType == NumberType.Decimal) initHexToDec();
		else if (outputType == NumberType.Binary) initHexToBin();
		else throw new Exception("Unsupported Conversion");
	}
	
	// Initialize Hexadecimal to decimal mapping
	private void initHexToDec() {
		hexToDec = new HashMap<Character, Integer>();
		
		hexToDec.put('0', 0);
		hexToDec.put('1', 1);
		hexToDec.put('2', 2);
		hexToDec.put('3', 3);
		hexToDec.put('4', 4);
		hexToDec.put('5', 5);
		hexToDec.put('6', 6);
		hexToDec.put('7', 7);
		hexToDec.put('8', 8);
		hexToDec.put('9', 9);
		hexToDec.put('A', 10);
		hexToDec.put('B', 11);
		hexToDec.put('C', 12);
		hexToDec.put('D', 13);
		hexToDec.put('E', 14);
		hexToDec.put('F', 15);		
	}
	
	// Initialize Hexadecimal to binary mapping 	
	private void initHexToBin() {
		hexToBin = new HashMap<Character, String>();
		
		hexToBin.put('0', "0000");
		hexToBin.put('1', "0001");
		hexToBin.put('2', "0010");
		hexToBin.put('3', "0011");
		hexToBin.put('4', "0100");
		hexToBin.put('5', "0101");
		hexToBin.put('6', "0110");
		hexToBin.put('7', "0111");
		hexToBin.put('8', "1000");
		hexToBin.put('9', "1001");
		hexToBin.put('A', "1010");
		hexToBin.put('B', "1011");
		hexToBin.put('C', "1100");
		hexToBin.put('D', "1101");
		hexToBin.put('E', "1110");
		hexToBin.put('F', "1111");
	}
	
	// Convert Hexadecimal to Decimal 
	// Throws exception if hexadecimal not found in string
	public int convertToDecimal(String inputHex) throws Exception {
		int pow=0;
		int base=16;
		int idx=inputHex.length()-1;
		int outputInt = 0;
		while(idx >= 0) {
			char tChar = inputHex.charAt(idx);
			// check if valid hex char
			if (hexToDec.containsKey(tChar))
				outputInt += (hexToDec.get(tChar) * Math.pow(base,pow));
			else 
				throw new Exception("Unsupported Hexadecimal character " + tChar);
			idx--;
			pow++;
		}
		return outputInt;
	}

	// Convert Hexadecimal to Binary
	// Throws exception if hexadecimal not found in string
	public String convertToBinary(String inputHex) throws Exception {
		StringBuffer outputStr = new StringBuffer();
		
		for (int ii=0; ii<inputHex.length(); ii++) {
			// check if valid hex char
			char tChar = inputHex.charAt(ii);
			if (hexToBin.containsKey(tChar)) 
				outputStr.append(hexToBin.get(tChar));	
			else
				throw new Exception("Unsupported Hexadecimal character " + tChar);			
		}
		
		return outputStr.toString();
	}

}
