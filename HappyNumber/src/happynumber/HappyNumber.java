package happynumber;
import java.util.*;

public class HappyNumber 
{
	public static void main(String [] args)
	{
		// scanner to scan input
		Scanner sc = new Scanner(System.in);
		
		// while there's stuff to read in the input
		while(sc.hasNext())
		{
			// get input as string
			String line  = sc.next();
			int number = Integer.parseInt(line);
			
			// set for infinite loop detection
			Set<Integer> set = new HashSet<>();
			
			int sum = happyNumberSum(number);
			
			// if we find a duplicate we have detected infinite loop
			while(!set.contains(sum))
			{
				set.add(sum);
				sum = happyNumberSum(sum);
			}
			
			// check for happy number
			if(sum == 1)
			{
				// number is a happy number
				System.out.print(1);
			}
			else
				// number is not a happy number
				System.out.print(0);
		}
		
		System.exit(0);
	}
	
	/**
	 * Method to find sum of given number digits
	 * @param num is the given number
	 * @return sum of number digits
	 */
	public static int happyNumberSum(int num)
	{
		// sum of digits
		int sum = 0;
		
		// power
		int n = 2;
		
		// placeholder for number
		int x = num;
		
		while(x != 0)
		{
			// get last digit of number
			int lastDigit = x % 10;
			
			// raise it to power of 2 and add to sum
			sum += Math.pow(lastDigit, n);
			
			// reduce number to get next last digit
			x /= 10;
		}
		
		return sum;
	}
}