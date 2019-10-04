package validparenthesis;
import java.util.*;

public class validParenthesis 
{
	public static void main(String [] args)
	{
		// scanner object to scan input
		Scanner sc = new Scanner(System.in);
		
		// while there's stuff to read
		while(sc.hasNext())
		{
			// get string and check it
			String line = sc.next();
			String result = isValid(line);
			System.out.println(result);
		}
		
		System.exit(0);
		
		/*
		 * Sample input
		 * ()()() -> True
		 * [()] -> True
		 * [([))) -> False
		 */	
	}
	
	/**
	 * Method to check if a string is balanced
	 * @param str the string to be checked
	 * @return False or True
	 */
	public static String isValid(String str)
	{
		// stack to check order or brackets
		Stack<Character> stack = new Stack<>();
		
		// length of string
		int len = str.length();
		
		for(int i = 0; i < len; i++)
		{
			// check for three types of opening brackets
			if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[')
			{
				stack.push(str.charAt(i));
			}
			
			// check for first closing bracket
			else if(!stack.isEmpty() && str.charAt(i) == ')' && stack.peek() == '(')
			{
				stack.pop();
			}
			
			// check for second closing bracket
			else if(!stack.isEmpty() && str.charAt(i) == '}' && stack.peek() == '{')
			{
				stack.pop();
			}
			
			// check for third closing bracket
			else if(!stack.isEmpty() && str.charAt(i) == ']' && stack.peek() == '[')
			{
				stack.pop();
			}
			else
				return "False";
		}
		
		// if stack is empty return True, else return False
		return stack.isEmpty() ? "True" : "False";
	}
}