package math_expression.test;

public class Test34 {
	interface External {
		int pow(int m, int n);
		int sqrt(int m);
		int pi();
	}
	
	public int sideA;
	
	public int sideB;
	
	public int sideC;
	
	public int perimeterTriangle;
	
	public int radius;
	
	public int perimeterCircle;
	
	private External external;
	
	public Test34 (External external) {
		this.external = external;
	}
	
	public void compute() {
		sideA = computeSideA();
		sideB = computeSideB();
		sideC = computeSideC();
		perimeterTriangle = computePerimeterTriangle();
		radius = computeRadius();
		perimeterCircle = computePerimeterCircle();
	}
	
	private int computeSideA() {
		return 3;
	}
	
	
	private int computeSideB() {
		return 4;
	}
	
	
	private int computeSideC() {
		 int powA = external.pow(this.sideA, 2);
		
		 int powB = external.pow(this.sideB, 2);
		
		int l1 = external.sqrt(powA + powB);
		int l0 = l1;
		return l0;
	}
	
	
	private int computePerimeterTriangle() {
		return this.sideA + this.sideB + this.sideC;
	}
	
	
	private int computeRadius() {
		return 5;
	}
	
	
	private int computePerimeterCircle() {
		 int diameter = 2 * this.radius;
		
		int l0 = diameter * external.pi();
		return l0;
	}
}
