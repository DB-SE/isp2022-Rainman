
public class Edge implements Comparable<Edge>{
	private int weight;
	
	@Override
	public int compareTo(Edge next) {
		return this.weight - next.weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return this.weight;
	}	 

	void print() {
		original();
		System.out.print(" weighted with " + weight);
	}
}