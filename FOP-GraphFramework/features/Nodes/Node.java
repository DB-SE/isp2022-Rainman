
public class Node {
	public static int id_ = 0;
	private int id;

    public Node() {
    	this.id = id_;
    	id_++;
    }
    
    public int getId() {
    	return this.id;
    }
    
    void print() {
    	System.out.print(id);
    }
    
    public String toString() {
    	return Integer.toString(this.id);
    }
}