package math_expression.test;

public class Test24 {
	
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
		 int i = this.x;
		
		int l0 = i * 2;
		return l0;
	}
}
