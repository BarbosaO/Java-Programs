package algorithms2;
public class algorithms2 
{
	public static void main(String [] args)
	{
		
		TreeNode root = new TreeNode(0);  
	    root.left = new TreeNode(-2);  
	    root.right = new TreeNode(3);  
	    root.left.left = new TreeNode(4);  
	    root.left.right = new TreeNode(-3);  
	    root.right.left = new TreeNode(6);  
	    root.right.right = new TreeNode(2);  
	    
     /*
      * 		 2
      * 	   /   \
      * 	 -2	    3
      * 	 / \   / \
      * 	4   3-6   2
      */
	     
	  System.out.println("Max Subtree Sum: " + findSubtreeMaxSum(root) + ", root: " + currRoot);	
	}
	
	public static class TreeNode 
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x)
		{
			val = x;
		}
	}
	
	static class INT 
	{ 
		int v; 
		INT(int a) 
		{ 
			v = a; 
		} 
	} 
	
	public static int currRoot = 0;
	public static int findSubtreeMaxSumAux(TreeNode root, int answer)
	{
		if(root == null)
		{
			return 0;
		}
		
		int currSum = root.val + findSubtreeMaxSumAux(root.left, answer) +
				findSubtreeMaxSumAux(root.right, answer);
		
		if(answer < currSum)
		{
			currRoot = root.val;
			answer.v = Math.max(answer, currSum); 
		}
		
		return currSum;
	}
	
	public static int findSubtreeMaxSum(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		
		INT answer = new INT(Integer.MIN_VALUE);
		
		findSubtreeMaxSumAux(root, answer);
		
		return answer.v;
	}
}
