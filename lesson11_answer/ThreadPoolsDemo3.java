package lesson11_answer;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 模拟客人进店，店内客人上限50，只有两个试衣间。
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
						System.out.println("有客进店！ 客人的id是"+id);						
						shopPool.execute(new DoSelect(id,fittingRoomPool));	
						}
						else{
							System.out.println("对不起，已经达到人数上限，请稍后在来！");
						}
					}
					
				}, 0, 1000);		

	}

}

//class MyTask extends TimerTask{   //
//
//	@Override
//	public void run() {
//		System.out.println("客人进店了！");
//			}
//	
//}

class DoSelect implements Runnable {  //挑衣服
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
		System.out.println("客人"+id+"：在挑衣服！");	 
		try {
			Thread.sleep(wait);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		System.out.println("客人"+id+"：挑好衣服，准备试穿！");	
		fittingRoomPool.execute(new DoTryFitting(id));
	}
	
}

class DoTryFitting implements Runnable{   //试衣服
	
	long id;
	Random rd = new Random();
	long wait = 10000+rd.nextInt(8000);
	
	public DoTryFitting(long id){
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.println("客人"+id+"：在试衣服");
		try {
			Thread.sleep(wait);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		System.out.println("客人"+id+"：试衣服完成！");
		
	}
	
}

