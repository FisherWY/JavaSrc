package lesson11_answer;
public class ThreadSafeTest implements Runnable {
	int num = 10; // ���õ�ǰ��Ʊ��
	
	public void run() {
		while (true) {
			if (num > 0) {
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("tickets" + num--);
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadSafeTest t = new ThreadSafeTest(); // ʵ���������
		Thread tA = new Thread(t); // �Ը������ֱ�ʵ����4���߳�
		Thread tB = new Thread(t);
		Thread tC = new Thread(t);
		Thread tD = new Thread(t);
		tA.start(); // �ֱ������߳�
		tB.start();
		tC.start();
		tD.start();
	}
}
