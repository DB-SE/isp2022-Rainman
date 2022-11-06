public class DirectedGraph extends GraphDecorator {
    public DirectedGraph(IGraph decoratedGraph) {
        super(decoratedGraph);
    }

    @Override
    public void minimumSpanningTree() {
        System.out.println("A minimum spanning tree can only be calculated on undirected graphs.");
    }
}
