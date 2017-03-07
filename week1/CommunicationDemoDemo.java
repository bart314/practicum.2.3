package demo;
import java.util.LinkedList;
import java.util.Queue;

public class CommunicationDemo {

	public static void main(String args[]) {
		final Queue<Integer> sharedQ = new LinkedList<>();

		Runnable producer = new Producer(sharedQ);
		Runnable consumer = new Consumer(sharedQ);

		new Thread(producer).start();
		new Thread(consumer).start();
	}

	static class Producer implements Runnable {
		private final Queue<Integer> sharedQ;

		public Producer(Queue<Integer> sharedQ) {
			this.sharedQ = sharedQ;
		}

		@Override
		public void run() {
			for (int i = 0; i < 14; i++) {
				synchronized (sharedQ) {
					while (sharedQ.size() >= 4) {
						try {
							System.out.println("Queue is full, waiting");
							sharedQ.wait();
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
					}
					System.out.println("producing : " + i);
					sharedQ.add(i);
					sharedQ.notify();
				}
			}
		}
	}

	static class Consumer implements Runnable {
		private final Queue<Integer> sharedQ;

		public Consumer(Queue<Integer> sharedQ) {
			this.sharedQ = sharedQ;
		}

		@Override
		public void run() {
			while(true) {

				synchronized (sharedQ) {
					//waiting condition - wait until Queue is not empty
					while (sharedQ.size() == 0) {
						try {
							System.out.println("        Queue is empty, waiting");
							sharedQ.wait();
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
					}
					int number = sharedQ.poll();
					System.out.println("        consuming : " + number );
					sharedQ.notify();

					//termination condition
					if(number == 3){break; }
				}
			}
		}
	}
}
