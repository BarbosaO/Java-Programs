package dfs;

import java.util.ArrayList;
import java.util.List;

public class Node<T extends Comparable<T>>
{
	T data;
	boolean visited;
	List<Node> neighbors;
	
	Node(T data)
	{
		this.data = data;
		this.neighbors = new ArrayList<>();
	}
	
	public void addneighbours(Node neighbourNode)
	{
		this.neighbors.add(neighbourNode);
	}
	
	public List getNeighbours() 
	{
		return neighbors;
	}
	
	public void setNeighbours(List newNeighbours)
	{
		neighbors = newNeighbours;
	}
}
