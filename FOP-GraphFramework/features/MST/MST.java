import java.util.ArrayList;
import java.util.LinkedList;

public class MST {
	private static LinkedList<Node> nodes;
	private static LinkedList<Edge> edges;
	
	public static void execute(Graph graph) {
		nodes = graph.getNodes();
		edges = graph.getEdges();
		
    	System.out.printf("\n\nMST: ");

    	//create int based list of edges using the enumeration
    	ArrayList<NumEdge> g_edges = new ArrayList<NumEdge>(edges.size());
    	for (Edge e: edges) {
    		g_edges.add(new NumEdge(nodes.indexOf(e.getSource()),nodes.indexOf(e.getDestination()),e.getWeight()));
    	}
    	NumEdge[] g = g_edges.toArray(new NumEdge[0]);
    	//component parent list
    	int parent[] = new int[nodes.size()];
    	//index of smallest edge going out of a component
    	int Min[] = new int[nodes.size()];
    	//initialize parents with identity (every vertex is a component)
    	for(int i=0;i<nodes.size();i++)
    	{
    		parent[i]=i; 
    	}

    	int edges = g.length-1;

    	int components = nodes.size();
    	ArrayList<NumEdge> ans_MST= new ArrayList<NumEdge>();

    	while(components>1)
    	{
    		// Initialize Min for each component as -1.
    		for(int i=0;i<nodes.size();i++)
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
    		for(int i=0;i<nodes.size();i++)
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
    		mstOutput(i);
    	} 
    }
	
	private static void mstOutput(NumEdge i) {
    	System.out.println("("+nodes.get(i.s)+","+nodes.get(i.d)+")");
	}
	
    //find "root"representative of a component
    private static int root(int[] parent, int v) {
        if(parent[v]==v)
			return v;

        return parent[v]=root(parent,parent[v]);
    }
    
    //merge components and by replacing one of their root representatives with the other 
    private static boolean merge(int[] parent, int v,int u) {
        v=root(parent,v);
        u=root(parent,u);
        if (v==u) return false;
        parent[v]=u;
        return true;
    }
}
