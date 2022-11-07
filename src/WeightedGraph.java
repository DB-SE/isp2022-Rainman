import java.util.ArrayList;

public class WeightedGraph extends GraphDecorator {

    public WeightedGraph(IGraph decoratedGraph) {
        super(decoratedGraph);
    }

    @Override
    public void minimumSpanningTree() {

    	ArrayList<Node> nodes = new ArrayList<>(numberOfNodes);
    	//get all vertices in an indexed list as a "cheap" enumeration
    	for (Edge e : edges) {
    		if (!nodes.contains(e.getSource())) {
    			nodes.add(e.getSource());
    		}
    		if (!nodes.contains(e.getDestination())) {
    			nodes.add(e.getDestination());
    		}
    	}
    	
    	//create int based list of edges using the enumeration
    	ArrayList<NumEdge> g_edges = new ArrayList<NumEdge>(edges.size());
    	for (Edge e: edges) {
    		g_edges.add(new NumEdge(nodes.indexOf(e.getSource()),nodes.indexOf(e.getDestination()),e.getWeight()));
    	}
    	NumEdge[] g = g_edges.toArray(new NumEdge[0]);
    	//component parent list
    	int[] parent = new int[numberOfNodes];
    	//index of smallest edge going out of a component
    	int[] Min = new int[numberOfNodes];
    	//initialize parents with identity (every vertex is a component)
    	for(int i=0;i<numberOfNodes;i++)
        {
            parent[i]=i; 
        }
    	
    	  int edges = g.length-1;
    	  
    	  int components = numberOfNodes;
    	  ArrayList<NumEdge> ans_MST= new ArrayList<NumEdge>();
    	  
    	  while(components>1)
    	  {
    	      // Initialize Min for each component as -1.
    	      for(int i=0;i<numberOfNodes;i++)
    	      {
    	          Min[i]=-1;
    	      }
    	      for(int i=0;i<=edges;i++)
    	      {
    	          // If both source and end are from same component we don't process them.
    	          if(root(parent,g[i].d)==root(parent,g[i].s))
    	          		continue;
    	         
    	          int r_s=root(parent,g[i].s);
    	          if(Min[r_s]==-1 || g[i].w < g[Min[r_s]].w)
					  Min[r_s]=i;
    	          
    	          int r_d=root(parent,g[i].d);
    	          if(Min[r_d]==-1 || g[i].w < g[Min[r_d]].w)
					  Min[r_d]=i;
    	          
    	      }
    	      //collect edges and merge components
    	      for(int i=0;i<numberOfNodes;i++)
    	      {
    	          if(Min[i]!=-1)
    	          {
    	              if(merge(parent,g[Min[i]].d,g[Min[i]].s))
    	              { 
    	            	  ans_MST.add(g[Min[i]]);
    	                  components--;
    	              }
    	          }
    	      }
    	  }
    	  System.out.println("Minimum Spanning Tree uses edges:");
    	  for (NumEdge i: ans_MST) {
    		  mstOutput(i, nodes);
    	  }
    	  
    	 
    }
    
    public void mstOutput(NumEdge i, ArrayList<Node> nodes) {
  		  System.out.println("("+nodes.get(i.s)+","+nodes.get(i.d)+") with weight " + i.w);
    }
}
