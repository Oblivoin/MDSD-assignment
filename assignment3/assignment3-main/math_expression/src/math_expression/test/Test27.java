package math_expression.test;

public class Test27 {
	interface External {
		int pi();
	}
	
	public int x;
	
	public int y;
	
	private External external;
	
	public Test27 (External external) {
		this.external = external;
	}
	
	public void compute() {
		x = computeX();
		y = computeY();
	}
	
	private int computeX() {
		return external.pi();
	}
	
	
	private int computeY() {
		return this.x + 2;
	}
}
