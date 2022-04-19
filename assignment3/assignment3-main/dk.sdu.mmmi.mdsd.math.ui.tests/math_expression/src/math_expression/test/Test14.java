	package math_expression.test;

	public class Test14 {
		
		public int x;
		
		public int y;
		
		public int z;
		
		
		public void compute() {
			x = computeX();
			y = computeY();
			z = computeZ();
		}
		
		private int computeX() {
			return 42;
		}
		
		
		private int computeY() {
			return 100 - 20 + 10 - 3;
		}
		
		
		private int computeZ() {
			return 100 * 20 / 10 * 3;
		}
	}
