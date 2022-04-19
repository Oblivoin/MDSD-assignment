package math_expression.test;

public class Test20 {
	
	public int x;
	
	
	public void compute() {
		x = computeX();
	}
	
	private int computeX() {
		 int y = 3;
		
		int l1 = y * y;
		y = 2;
		
		int l0 = l1 + y;
		return l0 + 76;
	}
}
