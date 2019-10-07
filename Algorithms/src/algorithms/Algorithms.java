package algorithms;

public class Algorithms 
{
	public static void main(String [] args)
	{
		int [] arr = {1,2,3,4,5,6,8,10,7,6,4,3};
		int [] arr2 = {1, 3, 4 ,5, 7, 8, 10, 12, 13, 14, 10, 9, 6, 2};
		System.out.println(unimodalMax(arr, 0, arr.length - 1));
		
	}

	/**
	 * Method to find the max in an unimodal array
	 * @param arr is the array
	 * @param low is starting point
	 * @param high is ending point
	 * @return max element in unimodal array
	 */
	public static int unimodalMax(int [] arr, int low, int high)
	{	
		// check if low is last element
		if(low == high - 1)
		{
			return arr[low];
		}
		
		// get mid pivot to look split array in half
		int mid = low + (high - low) / 2;
		
		// if peak is at left hand side
		if(arr[mid] < arr[mid + 1])
		{ 
			// recurse right hand side
			return unimodalMax(arr, mid + 1, high);
		}
		else	
			// recurse left hand side
			return unimodalMax(arr, low, mid);
	}
}
