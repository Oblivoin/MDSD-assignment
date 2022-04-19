package math_expression.test;

public class Test21 {
	
	public int x;
	
	public int y;
	
	
	public void compute() {
		x = computeX();
		y = computeY();
	}
	
	private int computeX() {
		return 42;
	}
	
	
	private int computeY() {
		return this.x;
	}
}
