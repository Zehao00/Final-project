class stop 
{
  int node;
  double distance;
		
  public stop(int node, double distance) 
  {
	  this.node = node;
	  this.distance = distance;
  }
		
  public int compareTo(stop a) 
  {
	  if (node > a.node) return 1;
	  if (node < a.node) return -1;
		 return 0;
  }
}