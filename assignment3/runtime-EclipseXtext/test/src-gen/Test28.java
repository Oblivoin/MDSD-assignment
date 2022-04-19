package math_expression.test;

public class Test28 {
	interface External {
		int sqrt(int m);
	}
	
	public int x;
	
	public int y;
	
	private External external;
	
	public Test28 (External external) {
		this.external = external;
	}
	
	public void compute() {
		x = computeX();
		y = computeY();
	}
	
	private int computeX() {
		return external.sqrt(4);
	}
	
	
	private int computeY() {
		return this.x * 2;
	}
}
