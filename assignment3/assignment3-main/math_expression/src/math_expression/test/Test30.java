package math_expression.test;

public class Test30 {
	interface External {
		int pow(int m, int n);
		int sqrt(int m);
		int pi();
	}
	
	public int x;
	
	private External external;
	
	public Test30 (External external) {
		this.external = external;
	}
	
	public void compute() {
		x = computeX();
	}
	
	private int computeX() {
		return external.sqrt(external.pow(external.pi(), 2));
	}
}
