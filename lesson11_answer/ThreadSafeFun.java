package lesson11_answer;

public class ThreadSafeFun implements Runnable {
	int num = 10;
	
	public void run() {
		while (true) {
//			synchronized ("") {
//				if (num > 0) {
//					try {
//						Thread.sleep(1000);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					System.out.println("tickets" + --num);
//				}
//			}
			fun();
			if(num<0)
			{
				break;
			}
			
		}
	}
	
	public synchronized void fun()
	{		
			if (num > 0) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("tickets" + --num);
			}
	}
	
	
	public static void main(String[] args) {
		ThreadSafeBlock t = new ThreadSafeBlock();
		Thread tA = new Thread(t);
		Thread tB = new Thread(t);
		Thread tC = new Thread(t);
		Thread tD = new Thread(t);
		tA.start();
		tB.start();
		tC.start();
		tD.start();
	}
}
