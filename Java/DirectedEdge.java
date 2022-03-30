/**
 Most of the skeleton code was copied from "https://algs4.cs.princeton.edu/44sp/DirectedEdge.java.html"
 */

public class DirectedEdge 
{
	
	private int startPoint;
	private int endPoint;
	private double cost;
	
	
	public DirectedEdge(int startPoint, int endPoint, double cost) 
	{
		this.cost = cost;
		this.endPoint = endPoint;
		this.startPoint = startPoint;
	}
	
	
	public int getStartPoint() 
	{
		return startPoint;
	}
	
	
	public int getEndPoint() 
	{
		return endPoint;
	}
	
	
	public double getCost() 
	{
		return cost;
	}
	
	
	public int compareTo(DirectedEdge e) 
	{
		if (cost > e.getCost()) return 1;
		if (cost < e.getCost()) return -1;
		return 0;
	}
	
	
	public String toString() 
	{
		String result = startPoint + " -> " + endPoint + ", cost: " + cost;
		return result;
	}
}