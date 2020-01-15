/*
Programme to perform Calculations Between Hexadecimal Numbers 
Addition Substractions Multiplications Dividation

*/
import java.util.*;
class HexCalc
{	
//method to convert char to corresponding intiger 
    public static int val(char c) 
    { 
        if (c >= '0' && c <= '9') 
            return (int)c - '0'; 
        else
            return (int)c - 'A' + 10; 
    } 
 //valid string check
    public static boolean checkValid(String s,int base)
    {/*
*Programme to perform Calculations Between Hexadecimal Numbers 
*Addition Substractions Multiplications Dividation

 */
import java.util.*;

class HexCalc {
	/** method to convert char to corresponding intiger
	 * 
	 * @param c part of a hexadecimal string
	 * @return corresponding intiger to that char like for hexadecimal 'A'->10 '8'->8
	 */
	public static int val(char c) {
		if (c >= '0' && c <= '9')
			return (int) c - '0';
		else
			return (int) c - 'A' + 10;
	}

	/**
	 * 
	 * @param s hexadecimal string
	 * @param base 
	 * @return if valid true else false
	 */
	public static boolean checkValid(String s, int base) {
		for (int i = 0; i < s.length() - 1; i++) {
			if (val(s.charAt(i)) >= base)
				return false;
		}
		return true;
	}

	/** convert given base string to decimal no
	 * 
	 * @param str hexadecimal String
	 * @param base base of the string
	 * @return converted decimal value of that string
	 */
	public static int toDeci(String str, int base) {
		int power = 1; // Initialize power of base
		int num = 0; // Initialize result
		// Decimal equivalent is
		// str[len-1]*1 + str[len-1]*
		// base + str[len-1]*(base^2) + ...
		for (int i = str.length() - 1; i >= 0; i--) {
			num += val(str.charAt(i)) * power;
			power = power * base;
		}

		return num;
	}

	static char reVal(int num) {
		if (num >= 0 && num <= 9)
			return (char) (num + 48);
		else
			return (char) (num - 10 + 65);
	}

	/** Function to convert a given decimal number to a given base 'base' and
	 * 
	 * @param base1 base of the number
	 * @param inputNum decimal input
	 * @return converted String from decimal to given base
	 */
	static String fromDeci(int base1, int inputNum) {
		String s = "";

		// Convert input number is given
		// base by repeatedly dividing it
		// by base and taking remainder
		while (inputNum > 0) {
			s += reVal(inputNum % base1);
			inputNum /= base1;
		}
		StringBuilder string_build = new StringBuilder();

		// append a string into StringBuilder input1
		string_build.append(s);

		// Reverse the result
		return new String(string_build.reverse());
	}

	/** method for addition
	 * 
	 * @param hex1 hexadecimal string input 1
	 * @param hex2 hexadecimal string input 2
	 * @param base base of string 
	 * @return converted string after addition
	 */
	static String add(String hex1, String hex2, int base) {
		int deci1 = toDeci(hex1, base);
		int deci2 = toDeci(hex2, base);
		return fromDeci(base, deci1 + deci2);
	}

	/** method for subtraction
	 * 
	 * @param hex1 hexadecimal string input 1
	 * @param hex2 hexadecimal string input 2
	 * @param base base of string 
	 * @return converted string after subtraction
	 */
	static String subtract(String hex1, String hex2, int base) {
		int deci1 = toDeci(hex1, base);
		int deci2 = toDeci(hex2, base);
		return fromDeci(base, deci1 - deci2);
	}
	/** method for multiplication
	 * 
	 * @param hex1 hexadecimal string input 1
	 * @param hex2 hexadecimal string input 2
	 * @param base base of string 
	 * @return converted string after multiplication
	 */
	static String multiply(String hex1, String hex2, int base) {
		int deci1 = toDeci(hex1, base);
		int deci2 = toDeci(hex2, base);
		return fromDeci(base, deci1 * deci2);
	}
	
	/** method for dividation
	 * 
	 * @param hex1 hexadecimal string input 1
	 * @param hex2 hexadecimal string input 2
	 * @param base base of string 
	 * @return converted string after dividation
	 */
	static String divide(String hex1, String hex2, int base) {
		int deci1 = toDeci(hex1, base);
		int deci2 = toDeci(hex2, base);
		return fromDeci(base, deci1 / deci2);
	}

	/** method for Compare
	 * @param hex1 hexadecimal string input 1
	 * @param hex2 hexadecimal string input 2
	 * @return 0 if equals 1 if grater -1 if less
	 */
	static int compare(String hex1, String hex2) {
		int flag = 0;
		if (hex1.length() > hex2.length()) {
			return 1;
		} else if (hex1.length() < hex2.length()) {
			return -1;
		}
		char[] c1 = hex1.toCharArray();
		char[] c2 = hex2.toCharArray();
		for (int i = 0; i < c1.length; i++) {
			if (c1[i] == c2[i])
				continue;
			else if (c1[i] > c2[i]) {
				flag = 1;
				break;
			} else {
				flag = -1;
				break;
			}
		}
		return flag;
	}

	/** check equality
	 * 
	 * @param hex1 hexadecimal string input 1
	 * @param hex2 hexadecimal string input 2
	 * @return true if both equal else false
	 */
	public static boolean isEqual(String hex1, String hex2) {
		int x = compare(hex1, hex2);
		if (x == 0)
			return true;
		else
			return false;
	}

	/** check greater
	 * 
	 * @param hex1 hexadecimal string input 1
	 * @param hex2 hexadecimal string input 2
	 * @return true if  greater else false
	 */
	public static boolean isGreater(String hex1, String hex2) {
		int x = compare(hex1, hex2);
		if (x == 1)
			return true;
		else
			return false;
	}

	/** check lesser
	 * 
	 * @param hex1 hexadecimal string input 1
	 * @param hex2 hexadecimal string input 2
	 * @return true if lesser  else false
	 */
	public static boolean isLesser(String hex1, String hex2) {
		int x = compare(hex1, hex2);
		if (x == -1)
			return true;
		else
			return false;
	}

	// method for valid String input
	public static String input() {
		String s;
		Scanner sc = new Scanner(System.in);
		while (true) {
			s = sc.next();
			if (HexCalc.checkValid(s, 16))
				break;
			else {
				System.out.println("please enter valid number");
				continue;
			}
		}
		return s;
	}

	// method for intiger input
	public static int input(int n) {
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				n = sc.nextInt();
			} catch (Exception e) {
				e.getMessage();
				System.out.println("please enter valid number");
				continue;
			}
			break;
		}
		return n;
	}

	// driver code
	public static void main(String[] args) {
		System.out.println("Welcome to hexcalc");
		while (true) {
			System.out.println("Please Choose from below options");
			System.out.println("1 . Add");
			System.out.println("2 . Subtract");
			System.out.println("3 . Multiply");
			System.out.println("4 . Divide");
			System.out.println("5 . Compare equal");
			System.out.println("6 . Compare grater");
			System.out.println("7 . Compare lesser");
			System.out.println("8 . Convert Hexadecimal to Decimal ");
			System.out.println("9 . convert Decimal to Hexadecimal");
			System.out.println("0 . Exit");
			int choise = 0;
			String hex1;
			String hex2;
			System.out.println("enter your choise");
			choise = input(1);
			switch (choise) {
			case 1:
				System.out.println("enter 2 Hexadecimal Numbers");
				hex1 = input();
				hex2 = input();
				System.out.println("Sum is " + HexCalc.add(hex1, hex2, 16));
				break;
			case 2:
				System.out.println("enter 2 Hexadecimal Numbers");
				hex1 = input();
				hex2 = input();
				System.out
						.println("Subtract is" + HexCalc.subtract(hex1, hex2, 16));
				break;
			case 3:
				System.out.println("enter 2 Hexadecimal Numbers");
				hex1 = input();
				hex2 = input();
				System.out.println("Multiplications is"
						+ HexCalc.multiply(hex1, hex2, 16));
				break;
			case 4:
				System.out.println("enter 2 Hexadecimal Numbers");
				hex1 = input();
				hex2 = input();
				System.out.println("Divide is" + HexCalc.divide(hex1, hex2, 16));
				break;
			case 5:
				System.out.println("enter 2 Hexadecimal Numbers");
				hex1 = input();
				hex2 = input();
				if (HexCalc.isEqual(hex1, hex2))
					System.out.println("Equal");
				else
					System.out.println("Not Equal");
				break;
			case 6:
				System.out.println("enter 2 Hexadecimal Numbers");
				hex1 = input();
				hex2 = input();
				if (HexCalc.isEqual(hex1, hex2))
					System.out.println("Equal");
				else
					System.out.println("Not Equal");
				break;
			case 7:
				System.out.println("enter 2 Hexadecimal Numbers");
				hex1 = input();
				hex2 = input();
				if (HexCalc.isEqual(hex1, hex2))
					System.out.println("Equal");
				else
					System.out.println("Not Equal");
				break;
			case 8:
				System.out.println("enter  Hexadecimal Number to convert");
				hex1 = input();
				System.out.println("Desimal form is" + HexCalc.toDeci(hex1, 16));
				break;
			case 9:
				System.out.println("enter  Decimal number to convert");
				int num;
				num = input(1);
				System.out.println(" Hexa decimal form is"
						+ HexCalc.fromDeci(16, num));
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Please Enter Correct ptiions");
			}

		}
	}

}
    	for (int i = 0; i<s.length()-1; i++) 
        {
            if(val(s.charAt(i))>=base)
            	return false;  
        }
        return true;
    }
//convert given base string to decimal no 
    public static int toDeci(String str,int base) 
    { 
        int power = 1; // Initialize  
                   // power of base 
        int num = 0; // Initialize result 
        // Decimal equivalent is  
        // str[len-1]*1 + str[len-1] * 
        // base + str[len-1]*(base^2) + ... 
        for (int i = str.length() - 1; i >= 0; i--) 
        {
            num += val(str.charAt(i)) * power; 
            power = power * base; 
        } 
  
        return num; 
    }
    static char reVal(int num) 
	{ 
    	if (num >= 0 && num <= 9) 
        	return (char)(num + 48); 
    	else
       		 return (char)(num - 10 + 65); 
	} 

// Function to convert a given decimal number 
// to a given base 'base' and 
	static String fromDeci(int base1, int inputNum) 
	{ 
    	String s = ""; 

    	// Convert input number is given 
    	// base by repeatedly dividing it 
    	// by base and taking remainder 
    	while (inputNum > 0) 
    	{ 
        	s += reVal(inputNum % base1); 
        	inputNum /= base1; 
    	} 
    	StringBuilder string_build = new StringBuilder(); 

        // append a string into StringBuilder input1 
        ix.append(s); 

    // Reverse the result 
    	return new String(string_build.reverse()); 
	}
	//method for addition
    static String add(String s1,String s2,int base)
    {
        int x1=toDeci(s1,base);
        int x2=toDeci(s2,base);
        return fromDeci(base,x1+x2);
    }
    //method for Substraction
    static String subtract(String s1,String s2,int base)
    {
        int x1=toDeci(s1,base);
        int x2=toDeci(s2,base);
        return fromDeci(base,x1-x2);
    }
    //method for Substraction
    static String multiply(String s1,String s2,int base)
    {
        int x1=toDeci(s1,base);
        int x2=toDeci(s2,base);
        return fromDeci(base,x1*x2);
    }
    //method for Divide
    static String divide(String s1,String s2,int base)
    {
        int x1=toDeci(s1,base);
        int x2=toDeci(s2,base);
        return fromDeci(base,x1/x2);
    }
    //method for Compare
    static int compare(String s1,String s2)
    {
    	int flag=0;
        if(s1.length()>s2.length())
        {
            return 1;
        }
        else if(s1.length()<s2.length())
        {
            return -1;
        }
    	char[] c1=s1.toCharArray();
    	char[] c2=s2.toCharArray();
    	int[] I={0,1,-1};
    	for(int i=0;i<c1.length;i++)
    	{
    		if(c1[i]==c2[i])
    			continue;
    		else if(c1[i]>c2[i])
    		{
    			flag=1;
    			break;
    		}
    		else
    		{
    			flag=-1;
    			break;
    		}
    	}
        return flag;
    }
    //check equality
    public static boolean isEqual(String s1,String s2)
    {
        int x=compare(s1,s2);
        if(x==0)
            return true;
        else
            return false;
    }
    //check grater
    public static boolean isGreater(String s1,String s2)
    {
        int x=compare(s1,s2);
        if(x==1)
            return true;
        else
            return false;
    }
    //check lesser
    public static boolean isLesser(String s1,String s2)
    {
        int x=compare(s1,s2);
        if(x==-1)
            return true;
        else
            return false;
    }
    //method for valid  String input
    public static String input()
    {
        String s;
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            s=sc.next();
            if(HexCalc.checkValid(s,16))
                break;
            else
            {
                System.out.println("please enter valid number");
                continue;
            }
        }
        return s;
    }
	//method for intiger input
	public static int input(int n)
    {
        while(true)
        {
			try
			{
				Scanner sc=new Scanner(System.in);
            n=sc.nextInt();
			}
			catch(Exception e)
			{
				e.getMessage();
				System.out.println("please enter valid number");
				continue;
			}
			break;
        }
        return n;
    }
    //driver code
    public static void main(String[] args) 
    {   
        System.out.println("Welcome to hexcalc");
        while(true)
        {
            System.out.println("Please Choose from below options");
            System.out.println("1 . Add");
            System.out.println("2 . Subtract");
            System.out.println("3 . Multiply");
            System.out.println("4 . Divide");
            System.out.println("5 . Compare equal");
            System.out.println("6 . Compare grater");
            System.out.println("7 . Compare lesser");
            System.out.println("8 . Convert Hexadecimal to Decimal ");
            System.out.println("9 . convert Decimal to Hexadecimal");
            System.out.println("0 . Exit");
        	int choise=0;
            String n1;
            String n2;
			System.out.println("enter your choise");
			choise=input(1);
            switch(choise)
            {
                case 1: System.out.println("enter 2 Hexadecimal Numbers");
                        n1=input();
                        n2=input();
                        System.out.println("Sum is "+HexCalc.add(n1,n2,16));break;
                case 2: System.out.println("enter 2 Hexadecimal Numbers");
                        n1=input();
                        n2=input();
                        System.out.println("Subtract is"+HexCalc.subtract(n1,n2,16));break;
                case 3: System.out.println("enter 2 Hexadecimal Numbers");
                        n1=input();
                        n2=input();
                        System.out.println("Multiplications is"+HexCalc.multiply(n1,n2,16));break;       
                case 4: System.out.println("enter 2 Hexadecimal Numbers");
                        n1=input();
                        n2=input();
                        System.out.println("Divide is"+HexCalc.divide(n1,n2,16));break;
                case 5: System.out.println("enter 2 Hexadecimal Numbers");
                        n1=input();
                        n2=input();
                        if(HexCalc.isEqual(n1,n2))
                            System.out.println("Equal");
                        else
                            System.out.println("Not Equal");
                        break;
                case 6: System.out.println("enter 2 Hexadecimal Numbers");n1=input();
                        n2=input();
                        if(HexCalc.isEqual(n1,n2))
                            System.out.println("Equal");
                        else
                            System.out.println("Not Equal");
                        break;
                case 7: System.out.println("enter 2 Hexadecimal Numbers");n1=input();
                        n2=input();
                        if(HexCalc.isEqual(n1,n2))
                            System.out.println("Equal");
                        else
                            System.out.println("Not Equal");
                        break;
                case 8: System.out.println("enter  Hexadecimal Number to convert");n1=input();System.out.println("Desimal form is"+HexCalc.toDeci(n1,16));break;
                case 9: System.out.println("enter  Decimal number to convert");int n;
						n=input(1);
                        System.out.println(" Hexa decimal form is"+HexCalc.fromDeci(16,n));break;
                case 0: System.exit(0);break;
                default:System.out.println("Please Enter Correct ptiions");
            }
    
		}   
	}

}