package math_expression.test;

public class Test22 {
	
	public int x;
	
	public int y;
	
	
	public void compute() {
		x = computeX();
		y = computeY();
	}
	
	private int computeX() {
		return 40 + 2;
	}
	
	
	private int computeY() {
		return this.x * 2;
	}
}
