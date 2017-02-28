package demo;

public class MultiThreadingDemo {
	public static void main(String[] args) {
		Runnable r1 = new Runner("dingen", 100, 0);
		Runnable r2 = new Runner("aardappelen", 75, 8);

		Thread th1 = new Thread(r1);
		Thread th2 = new Thread(r2);

		th1.start();
		th2.start();
	}


	static class Runner implements Runnable {
		private String printable;
		private int numberOfTimes;
		private int spaces;

		public Runner (String foo, int times, int s) {
			printable = foo;
			numberOfTimes = times;
			spaces = s;
		}


		@Override
		public void run() {
			for (int i=0; i<numberOfTimes; i++) {
				printSpaces();
				System.out.println("Running and printing "+printable);
			}
		}
		
		private void printSpaces() {
			for (int i=0; i<spaces; i++) {
				System.out.print(" ");
			}
		}
	}

}
