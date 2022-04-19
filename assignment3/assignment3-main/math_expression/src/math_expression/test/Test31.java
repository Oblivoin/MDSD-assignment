package math_expression.test;

public class Test31 {
	interface External {
		int pow(int m, int n);
	}
	
	public int x;
	
	public int y;
	
	private External external;
	
	public Test31 (External external) {
		this.external = external;
	}
	
	public void compute() {
		x = computeX();
		y = computeY();
	}
	
	private int computeX() {
		return 5;
	}
	
	
	private int computeY() {
		 int i = this.x;
		
		int l0 = i - 3;
		return 2 + external.pow(l0, 3 * 2);
	}
}
