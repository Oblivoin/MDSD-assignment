package math_expression.test;

public class Test33 {
	
	public int a;
	
	public int b;
	
	public int c;
	
	public int d;
	
	
	public void compute() {
		a = computeA();
		b = computeB();
		c = computeC();
		d = computeD();
	}
	
	private int computeA() {
		return 40;
	}
	
	
	private int computeB() {
		 int i = 2;
		
		int l0 = this.a * i;
		return l0;
	}
	
	
	private int computeC() {
		return this.b * 3;
	}
	
	
	private int computeD() {
		 int i = 4;
		
		int l0 = this.c + i;
		return l0;
	}
}
