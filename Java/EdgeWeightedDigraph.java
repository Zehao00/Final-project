/**
 Most of the skeleton code was copied from "https://algs4.cs.princeton.edu/44sp/EdgeWeightedDigraph.java.html"
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EdgeWeightedDigraph 
{
	
	private List<DirectedEdge>[] adj;      // adjacency list matrix
	private int V;                         // number of vertices
	private int E;                         // number of numbers
	
	
	@SuppressWarnings("unchecked")
	public EdgeWeightedDigraph(int V) 
	{
		this.E = 0;
		this.V = V;
		adj = (List<DirectedEdge>[]) new List[V];
		for (int i = 0; i < V; i++) 
		{
			adj[i] = new ArrayList<>();
		}
	}
	
	
	public void addEdge(DirectedEdge e) 
	{
		adj[e.getStartPoint()].add(e);
		E++;
	}
	
	
	public int V() 
	{
		return V;
	}
	
	
	public int E() 
	{
		return E;
	}
	
	
	public Iterable<DirectedEdge> adj(int v) 
	{
		return adj[v];
	}
	
	
	public Iterable<DirectedEdge> edges() 
	{
		List<DirectedEdge> edges = new ArrayList<>();
		for (int i = 0; i < V; i++) 
		{
			for (DirectedEdge e : adj[i]) 
			{
				edges.add(e);
			}
		}
		return edges;
	}
	
	
	public String toString() 
	{
		String s = V + " vertices, " + E + " edges\n";
		for (int i = 0; i < V; i++) 
		{
			s += i + ": ";
			for (DirectedEdge e : adj(i)) 
			{
				s += e.getEndPoint() + " [" + e.getCost() + "], ";
			}
			s += "\n";
		}
		return s;
	}
	
	
	public void readData(String fileName, EdgeWeightedDigraph theGraph)
	{
		try
		{
			File name = new File(fileName);
			Scanner scanner = new Scanner(name);
            String[] data = scanner.nextLine().split(",");
		    
		    while(scanner.hasNextLine())
    	    {
		    	data = scanner.nextLine().split(",");
		    	int i = Integer.parseInt(data[0]);
		    	int j = Integer.parseInt(data[1]);
		    	if(Integer.parseInt(data[2]) == 0)
		    	{
		    		double theCost = 0.0;
		    		DirectedEdge edge = new DirectedEdge(i, j, theCost);
		    		theGraph.addEdge(edge);
		    	}
		    	else
		    	{
		    		double theCost = Integer.parseInt(data[3])/100;
		    		DirectedEdge edge = new DirectedEdge(i, j, theCost);
		    		theGraph.addEdge(edge);
		    	}
    	    }
		    scanner.close();
		}catch(Exception e) {System.out.print("");}
	}
}
