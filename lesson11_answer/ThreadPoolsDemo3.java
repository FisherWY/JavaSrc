package lesson11_answer;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ģ����˽��꣬���ڿ�������50��ֻ���������¼䡣
 *
 */
public class ThreadPoolsDemo3 {
	static ExecutorService shopPool ;
	static ExecutorService fittingRoomPool ;
	static int num =0;
	
	public static void main(String[] args) {
		fittingRoomPool = Executors.newFixedThreadPool(2);
		shopPool = Executors.newFixedThreadPool(5);
		final Timer myTimer = new Timer();
		final Random rd = new Random();
		
		myTimer.schedule(
				new TimerTask(){
					@Override
					public void run() {
						long id = 10000l+rd.nextInt(1000);
						int ActiveThread = ((ThreadPoolExecutor)shopPool).getActiveCount();
						if(ActiveThread <5){
						System.out.println("�пͽ��꣡ ���˵�id��"+id);						
						shopPool.execute(new DoSelect(id,fittingRoomPool));	
						}
						else{
							System.out.println("�Բ����Ѿ��ﵽ�������ޣ����Ժ�������");
						}
					}
					
				}, 0, 1000);		

	}

}

//class MyTask extends TimerTask{   //
//
//	@Override
//	public void run() {
//		System.out.println("���˽����ˣ�");
//			}
//	
//}

class DoSelect implements Runnable {  //���·�
    long id;
    ExecutorService fittingRoomPool;
	public DoSelect(long id,ExecutorService fittingRoomPool ){
		this.id = id;
		this.fittingRoomPool = fittingRoomPool;		
	}
	Random rd = new Random();
	long wait = 10000+rd.nextInt(5000);
	@Override
	public void run() {
		System.out.println("����"+id+"�������·���");	 
		try {
			Thread.sleep(wait);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		System.out.println("����"+id+"�������·���׼���Դ���");	
		fittingRoomPool.execute(new DoTryFitting(id));
	}
	
}

class DoTryFitting implements Runnable{   //���·�
	
	long id;
	Random rd = new Random();
	long wait = 10000+rd.nextInt(8000);
	
	public DoTryFitting(long id){
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.println("����"+id+"�������·�");
		try {
			Thread.sleep(wait);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		System.out.println("����"+id+"�����·���ɣ�");
		
	}
	
}

