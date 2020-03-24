package Evaluation;
/**
 * this class evaluate value of infix expression
 * @author Bhavesh
 *
 */
public class Stack implements IStack {

	private String stack[]=new String[Max_Size];
	private int top=-1;
	/**
	 * this method push the item in the stack
	 * @param item the value to add in the stack
	 */
	public void push(String item)
	{
		if(top==Max_Size)
		{
			System.out.println("stack overflow");
		}
		else
		{
		top++;
		stack[top]=item;
		}
	}
	/**
	 * this method pop the top value of stack
	 * @return the top popped value of the stack
	 */
	public String pop()
	{
		if(top==-1)
		{
			System.out.println("stack underflow");
			return null;
		}
		else
		{
		String item=stack[top];
		top--;
		return item;
		}
	}
	/**
	 * this method convert infix expression into postfix expression
	 * @param infix expression to convert in postfix
	 * @return the postfix converted from given infix expression
	 */
	public String toPostFix(String infix)
	{
		String postFix="";
		String str="";
		for(int i=0;i<infix.length();i++)
		{
			if((' ')==(infix.charAt(i)) || (i==infix.length()-1))
			{ 
				if((i==infix.length()-1))
				{
					str=str+infix.charAt(i);
				}
				if(this.getPrecedence(str)==0)
				{
					postFix=postFix+str+" "; 
					str="";
				}
				else
				{
					if(this.isEmpty())
					{
						this.push(str);
						str="";
					}
					else
					{
					if(this.getPrecedence(str)>this.getPrecedence(stack[top]))
					{
						this.push(str);
						str="";
					}
					else
					{
						String operator=this.pop();
						this.push(str);
						str="";
						if(this.getPrecedence(operator)!=5)
						{
						postFix=postFix+operator+" "; 
						}
					}
					}
				}
			}
			else
			{
				str=str+infix.charAt(i);
			}
		}
		while(!this.isEmpty())
		{
			String operator=this.pop();
			if(this.getPrecedence(operator)!=5)
			{
			postFix=postFix+operator+" "; 
			}		
			}
		return postFix;
	}
	/**
	 * this method return precedence of the item 
	 * @param item the item of which precedence is calculated 
	 * @return precedence of the item
	 */
	public int getPrecedence(String item)
	{ 
		int precendece=0;
		if(item.equals("(") || item.equals(")"))
		{
			precendece= 5;
		}
		else if(item.equals("==") || item.equals("<=") ||item.equals("!=") ||item.equals(">=") || item.equals("<") ||item.equals(">"))
		{
			precendece= 1;
		}
		else if(item.equals("&&") || item.equals("||") || item.equals("!") )
		{
			precendece= 2;
		}
		else if(item.equals("+") ||item.equals("-") )
		{
			precendece= 3;
		}
		else if(item.equals("/") ||item.equals("*") )
		{
			precendece= 4;
		}
		return precendece;
	}
	/**
	 * @return true if stack is empty
	 */
	public Boolean isEmpty()
	{
		if(top==-1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * this method evaluate postfix expression
	 * @param postFix expression to evaluate
	 * @return the evaluated value of postfix expression
	 */
	public int evaluatePostFix( String postFix)
	{
		top=-1;
		String str="";
		for(int i=0;i<postFix.length();i++)
		{
			
			if((' ')==(postFix.charAt(i)) || (i==postFix.length()-1))
			{ 
				
				if(this.getPrecedence(str)==0)
				{
					this.push(str);
					str="";
				}
				else
				{
					
					int number1=Integer.parseInt(this.pop());
					int number2=Integer.parseInt(this.pop());
					

					int result=0;
					if(str.equals("+"))
					{
						result=number2+number1;
					}
					else if(str.equals("-"))
					{
						result=number2-number1;
					}
					else if(str.equals("*"))
					{
						result=number2*number1;
					}
					else if(str.equals("/"))
					{
						result=number2/number1;
					}
					else if(str.equals("=="))
					{
						if(number2==number1)
						{
							result=1;
						}
						else
						{
							result=0;
						}
					}
					else if(str.equals("!="))
					{
						if(number2==number1)
						{
							result=0;
						}
						else
						{
							result=1;
						}
					}
					else if(str.equals("<="))
					{
						if(number2<=number1)
						{
							result=1;
						}
						else
						{
							result=0;
						}
					}
					else if(str.equals(">="))
					{
						if(number2>=number1)
						{
							result=1;
						}
						else
						{
							result=0;
						}
					}
					else if(str.equals("<"))
					{
						if(number2<number1)
						{
							result=1;
						}
						else
						{
							result=0;
						}
					}
					else if(str.equals(">"))
					{
						if(number2>number1)
						{
							result=1;
						}
						else
						{
							result=0;
						}
					}
					else if(str.equals("||"))
					{
						if(number2!=0 || number1!=0 )
						{
							result=1;
						}
						else
						{
							result=0;
						}
					}
					else if(str.equals("&&"))
					{
						if(number2!=0 && number1!=0 )
						{
							result=1;
						}
						else
						{
							result=0;
						}
					}
					this.push(String.valueOf(result));
					str="";
				}
			}
			else
			{
				str=str+postFix.charAt(i);
			}
		}
		int evaluatedResult=Integer.parseInt(this.pop());
		return evaluatedResult;
	}

}
