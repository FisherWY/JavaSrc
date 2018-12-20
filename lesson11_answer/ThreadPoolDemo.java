package lesson11_answer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

	public static void main(String[] args) {
		
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		for(int i=0;i<5;i++)
		{
			Runnable run = new Runnable(){
				@Override
				public void run() {
					Thread t = Thread.currentThread();
					System.out.println(t.getName()+"����ִ�����񡣡�����");	
				   try {
					Thread.sleep(5000);
				} catch (InterruptedException e ) {					
					System.out.println("�߳�ֹͣ�ˣ�");
				}
				   System.out.println(t.getName()+"ִ���������");
				}				
			};
			threadPool.execute(run);	// ��ʵϰrunnable�ӿڶ�������ý����̳߳ع���
			System.out.println("���̳߳����һ������");
		}
		
		threadPool.shutdown();
		//threadPool.shutdownNow();
		System.out.println("�̳߳عر�");

	}

}
