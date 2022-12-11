import java.util.ArrayList;

import graph.Edge;
import graph.Graph;
import graph.Node;
import graph.NumEdge;
import interfaces.EdgePlugin;

public class Weighted implements EdgePlugin {
	
	private Graph graph;
	
	@Override
	public void setGraph(Graph graph) {
		this.graph = graph;
	}

    @Override
    public void minimumSpanningTree() {

    	ArrayList<Node> nodes = graph.getNodes();
    	
    	//create int based list of edges using the enumeration
    	ArrayList<NumEdge> g_edges = new ArrayList<NumEdge>(graph.edges.size());
    	for (Edge e: graph.edges) {
    		g_edges.add(new NumEdge(nodes.indexOf(e.getSource()),nodes.indexOf(e.getDestination()),e.getWeight()));
    	}
    	NumEdge[] g = g_edges.toArray(new NumEdge[0]);
    	//component parent list
    	int[] parent = new int[graph.numberOfNodes];
    	//index of smallest edge going out of a component
    	int[] Min = new int[graph.numberOfNodes];
    	//initialize parents with identity (every vertex is a component)
    	for(int i=0;i<graph.numberOfNodes;i++)
        {
            parent[i]=i; 
        }
    	
    	  int edges = g.length-1;
    	  
    	  int components = graph.numberOfNodes;
    	  ArrayList<NumEdge> ans_MST= new ArrayList<NumEdge>();
    	  
    	  while(components>1)
    	  {
    	      // Initialize Min for each component as -1.
    	      for(int i=0;i<graph.numberOfNodes;i++)
    	      {
    	          Min[i]=-1;
    	      }
    	      for(int i=0;i<=edges;i++)
    	      {
    	          // If both source and end are from same component we don't process them.
    	          if(graph.root(parent,g[i].d)==graph.root(parent,g[i].s))
    	          		continue;
    	         
    	          int r_s=graph.root(parent,g[i].s);
    	          if(Min[r_s]==-1 || g[i].w < g[Min[r_s]].w)
					  Min[r_s]=i;
    	          
    	          int r_d=graph.root(parent,g[i].d);
    	          if(Min[r_d]==-1 || g[i].w < g[Min[r_d]].w)
					  Min[r_d]=i;
    	          
    	      }
    	      //collect edges and merge components
    	      for(int i=0;i<graph.numberOfNodes;i++)
    	      {
    	          if(Min[i]!=-1)
    	          {
    	              if(graph.merge(parent,g[Min[i]].d,g[Min[i]].s))
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
    
    private void mstOutput(NumEdge i, ArrayList<Node> nodes) {
		  System.out.println("("+nodes.get(i.s)+","+nodes.get(i.d)+") with weight " + i.w);
  }

	@Override
	public void depthFirstSearch() {
		graph.baseDepthFirstSearch();
		
	}
	
	@Override
	public void dfsRecursive(ArrayList<Node> nodes, Node node, boolean[] isVisited) {
		graph.baseDfsRecursive(nodes, node, isVisited);
	}

	@Override
	public void breadthFirstSearch() {
		graph.baseBreadthFirstSearch();
	}

}
