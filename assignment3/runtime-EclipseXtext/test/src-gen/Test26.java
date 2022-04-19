package math_expression.test;

public class Test26 {
	
	public int x;
	
	public int y;
	
	
	public void compute() {
		x = computeX();
		y = computeY();
	}
	
	private int computeX() {
		return 21;
	}
	
	
	private int computeY() {
		 int x = this.x + 1;
		
		int l0 = x * 2;
		return l0;
	}
}
