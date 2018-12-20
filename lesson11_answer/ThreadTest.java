package lesson11_answer;
public class ThreadTest extends Thread { // ָ����̳�Thread��
	private int count = 10;
	
	public void run() { // ��дrun()����
		while (true) {
			System.out.print(count+" "); // ��ӡcount����
			if (--count == 0) { // ʹcount�����Լ������Լ�Ϊ0ʱ���˳�ѭ��
								
				return;				
			}
			
		}
		//System.out.print("�̹߳ر�"+count+" "); // ��ӡcount����
	}
	
	public static void main(String[] args) {
		new ThreadTest().start();
	}
}
