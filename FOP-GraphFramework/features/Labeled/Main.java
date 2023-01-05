import java.util.LinkedList;

public class Main {
	
	protected void run() {
		original();
		LinkedList<Node> nodes = graphs.get(0).getNodes();
		
		nodes.get(0).setLabel("a");
		nodes.get(1).setLabel("b");
		nodes.get(2).setLabel("c");
		nodes.get(3).setLabel("d");
		nodes.get(4).setLabel("e");
	}
}