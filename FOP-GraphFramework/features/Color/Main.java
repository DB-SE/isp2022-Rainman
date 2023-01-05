import java.awt.Color;
import java.util.LinkedList;

public class Main {

	protected void run() {
		original();
		LinkedList<Node> nodes = graphs.get(0).getNodes();
		
		nodes.get(0).setColor(Color.BLACK);
		nodes.get(1).setColor(Color.CYAN);
		nodes.get(2).setColor(Color.MAGENTA);
		nodes.get(3).setColor(Color.ORANGE);
		nodes.get(4).setColor(Color.RED);
	}
}