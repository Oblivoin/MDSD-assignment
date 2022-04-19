	package math_expression.test;

	public class Test29 {
		interface External {
			int pow(m, n);
		}
		
		public int x;
		
		public int y;
		
		private External external;
		
		public Test29 (External external) {
			this.external = external;
		}
		
		public void compute() {
			x = computeX();
			y = computeY();
		}
		
		private int computeX() {
			return external.pow(4, 2;
		}
		
		
		private int computeY() {
			return this.x - 2;
		}
	}
