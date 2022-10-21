public class Edge implements Comparable<Edge> {
    private Node source;
    private Node destination;
    private int weight;

    public Edge(Node source, Node destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge next) {
        return this.weight - next.weight;
    }
}
