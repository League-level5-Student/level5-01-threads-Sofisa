package _06_Wait_and_Notify.Practice;

/*
 
Below are two threads. One thread increments the counter
and the other thread prints the result. If you run the
program as it is, you'll notice that the output in not
sequential.

Your goal is to modify the code inside the threads so that 
they are in synch. Use synchronized, wait, and notify to make
it so that 
t1 will only increase counter after 
t2 has printed 
the previous result. The output should be the numbers 0 to 100000
printed in order.
  
*/

public class SynchedSplitLoops {
	static Object threadLock = new Object();

	static int counter = 0;

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {

			synchronized (threadLock) {
				
				//System.out.println("Thread 1 " + counter);
				for (int i = 0; i < 1000; i++) {
					
					threadLock.notify();
					counter++;
					System.out.println("Thread 1 " + counter);

					try {
						threadLock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		
		
		//threadLock.notify();
		Thread t2 = new Thread(() -> {
			
			synchronized (threadLock) {
				//System.out.println("Thread 2 " + counter);
				for (int i = 0; i < 1000; i++) {
					
					threadLock.notify();
					System.out.println("Thread 2 " + counter);
					try {
						threadLock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
			threadLock.wait();
		} catch (InterruptedException e) {
			System.err.println("Could not join threads");
		}

	}

}
