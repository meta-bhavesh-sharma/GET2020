package Evaluation;
/**Main Method Containing Class
 * 
 * @author Bhavesh
 *
 */
public class View {
	public static void main(String []args)
	{
		Stack stack=new Stack();
		String infix=" 3 * ( 4 > 2 )";
		String postFix=stack.toPostFix(infix);
		System.out.println("post fix is "+postFix);
		int evaluatedResult=stack.evaluatePostFix(postFix);	
		System.out.println("Evaluation of infix is "+evaluatedResult);
	}

}
