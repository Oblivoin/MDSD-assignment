	package math_expression.test;

	public class Test32 {
		
		public int a;
		
		public int b;
		
		public int c;
		
		public int d;
		
		public int e;
		
		
		public void compute() {
			a = computeA();
			b = computeB();
			c = computeC();
			d = computeD();
			e = computeE();
		}
		
		private int computeA() {
			return 40;
		}
		
		
		private int computeB() {
			return 40 + 2;
		}
		
		
		private int computeC() {
			return 40 + 5 - 10 - 8;
		}
		
		
		private int computeD() {
			return 40 + 2 * 4 + 80;
		}
		
		
		private int computeE() {
			return (40 + 2) * (4 + 80);
		}
	}
