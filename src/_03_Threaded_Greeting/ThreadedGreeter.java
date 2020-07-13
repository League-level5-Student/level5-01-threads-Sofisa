package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable {
	// member variable
	private int member;

	// constructor
	public ThreadedGreeter(int member) {
		this.member = member;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hello from thread number: " + member);
		if (member <= 50) {
			Thread n = new Thread(new ThreadedGreeter(member + 1));
			n.start();
			try {
				n.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
