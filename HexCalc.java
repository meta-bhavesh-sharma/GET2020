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
    {
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
    	StringBuilder ix = new StringBuilder(); 

        // append a string into StringBuilder input1 
        ix.append(s); 

    // Reverse the result 
    	return new String(ix.reverse()); 
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