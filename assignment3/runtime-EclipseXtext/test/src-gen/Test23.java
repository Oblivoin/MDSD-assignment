package math_expression.test;

public class Test23 {
	
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
		 int i = 2;
		
		int l0 = i * this.x;
		return l0;
	}
}
