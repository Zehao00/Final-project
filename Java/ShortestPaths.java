import java.util.List;
import java.util.Stack;
/**
 Most of the skeleton code was copied from "https://algs4.cs.princeton.edu/44sp/DijkstraSP.java.html"
 */

public class ShortestPaths 
{
	private double[] distTo;
	private IndexMinPQ<Double> pq; 
	private DirectedEdge[] edgeTo;
	
	public ShortestPaths(EdgeWeightedDigraph graph, int begin) 
	{
		 for (DirectedEdge e : graph.edges()) 
		 {
	            if (e.getCost() < 0)
	                throw new IllegalArgumentException("edge " + e + " has negative weight");
	     }

	        distTo = new double[graph.V()];
	        edgeTo = new DirectedEdge[graph.V()];
	        validateVertex(begin);

	        for (int v = 0; v < graph.V(); v++)
	        distTo[v] = Double.POSITIVE_INFINITY;
	        distTo[begin] = 0.0;

	        // relax vertices in order of distance from s
	        pq = new IndexMinPQ<Double>(graph.V());
	        pq.insert(begin, distTo[begin]);
	        while (!pq.isEmpty()) 
	        {
	            int v = pq.delMin();
	            for (DirectedEdge e : graph.adj(v))
	                relax(e);
	        }
	}
	
	
	private void relax(DirectedEdge e) 
	{
        int v = e.getStartPoint(), w = e.getEndPoint();
        if (distTo[w] > distTo[v] + e.getCost()) 
        {
            distTo[w] = distTo[v] + e.getCost();
            edgeTo[w] = e;
            if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
            else                pq.insert(w, distTo[w]);
        }
    }
	
	
	public double disTo(int v) 
	{
		validateVertex(v);
		return distTo[v];
	}
	
	
	public boolean hasPath(int v) 
	{
		validateVertex(v);
		return distTo[v] < Double.POSITIVE_INFINITY;
	}
	
	
	public List<DirectedEdge> pathTo(int v) 
	{
		validateVertex(v);
		if (!hasPath(v)) return null;
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.getStartPoint()]) 
        {
            path.push(e);
        }
        return path;
	}
	
	
	private void validateVertex(int v) 
	{
        int V = distTo.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
}