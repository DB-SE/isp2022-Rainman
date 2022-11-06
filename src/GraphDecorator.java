public abstract class GraphDecorator implements IGraph {
    protected IGraph decoratedGraph;
    public GraphDecorator(IGraph decoratedGraph) {
        this.decoratedGraph = decoratedGraph;
    }
    public void depthFirstSearch(Node start) {
        decoratedGraph.depthFirstSearch(start);
    }
    public void minimumSpanningTree() {
        decoratedGraph.minimumSpanningTree();
    }
}
