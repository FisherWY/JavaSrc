package lesson11_answer;
/**
 * �߳��ṩ��һ����̬����:
 * static Thread currentThread()
 * �÷������Ի�ȡ��������������߳�
 * 
 * java�����д��붼�ǿ��߳����еģ�main����Ҳ�����⡣
 * ֻ��������main�������̲߳��������Ǵ����ġ�
 * 
 * @author adminitartor
 *
 */
public class Thread_currentThread {
	public static void main(String[] args) {
		//��ȡ����main�������߳�?
		Thread main = Thread.currentThread();
		System.out.println("����main�������߳���:"+main);	
		dosome();
		
		Thread t = new Thread(){
			public void run(){
				Thread t = Thread.currentThread();
				System.out.println("�Զ����߳�:"+t);
				dosome();
			}
		};
		t.start();
	}

	public static void dosome(){
		Thread t = Thread.currentThread();
		System.out.println("����dosome�������߳���:"+t);
	}
	
	
}









