
public class Decimal {
	
	char [] decToHex;
	
	public Decimal() {
		decToHex = new char[] { '0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F' };		
	}
 

	public String convertToBinary(int inputDec) {
		if (inputDec == 0) return "0";
		
		StringBuffer output = new StringBuffer();
		
		final int base = 2;
		
		int ans = inputDec;
		while (ans != 0) {			
			int rem = ans%base;
			output.append(rem);
			ans = ans/base;
		}
		
		return(output.reverse().toString());
	}
	
	public String convertToHexadecimal(int inputDec) {
		
		if (inputDec == 0) return "0";
		
		StringBuffer output = new StringBuffer();
		
		final int base = 16;
		
		int ans = inputDec;
		while (ans != 0) {			
			int rem = ans%base;
			output.append(decToHex[rem]);
			ans = ans/base;
		}
		
		return(output.reverse().toString());
	}
	
}
