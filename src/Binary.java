// This class is used to convert input binary string to decimal and hexadecimal formats
public class Binary {
	
	// Contains mapping of integers 0-15 to hexadecimal 0-F
	char [] decToHex;
	
	// Initialize mapping
	public Binary() {
		decToHex = new char[] { '0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F' };
	}
	
	// Binary to Decimal conversion.
	public int convertToDecimal(String inputBinary) throws Exception
	{		
		return convert(inputBinary, inputBinary.length());
	}
	
	// Converts binary string to hexadecimal string
	public String convertToHexadecimal(String inputBinary) throws Exception 
	{
		final int HEX_CHAR_LEN = 4;
		int len = inputBinary.length();
		
		StringBuffer retVal = new StringBuffer();
		
		// Convert left most characters 
		int remainder = len % HEX_CHAR_LEN;
		if (remainder != 0) {
			String tempStr = inputBinary.substring(0, remainder);
			int tempDec = convert(tempStr, HEX_CHAR_LEN);
			retVal.append(decToHex[tempDec]);
		}
		
		// convert remaining char in sets of 4
		int idx = remainder;				
		while (idx < len) { 			
			String tempStr = inputBinary.substring(idx, idx+HEX_CHAR_LEN);
			int tempDec = convert(tempStr, HEX_CHAR_LEN);
			retVal.append(decToHex[tempDec]);	
			idx = idx+HEX_CHAR_LEN;
		}
		
		return retVal.toString();
	}
	
	// Utility method to convert any binary string to its equivalent decimal value
	private int convert(String inputStr, int strLength) throws Exception {
		int idx = strLength-1;
		int powerOf2 = 0;
		int retInteger = 0;
		while (idx >=0) {
			int nextInt = Character.getNumericValue(inputStr.charAt(idx));
			if (nextInt == 1)
				retInteger +=  Math.pow(2, powerOf2);
			else if (nextInt != 0)
				throw new Exception("Invalid Binary String");
			
			powerOf2++;
			idx--;
		}
		return retInteger;
	}
}
