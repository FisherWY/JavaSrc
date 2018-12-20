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
					System.out.println(t.getName()+"正在执行任务。。。。");	
				   try {
					Thread.sleep(5000);
				} catch (InterruptedException e ) {					
					System.out.println("线程停止了！");
				}
				   System.out.println(t.getName()+"执行任务结束");
				}				
			};
			threadPool.execute(run);	// 把实习runnable接口对象的引用交给线程池管理。
			System.out.println("个线程池添加一个任务");
		}
		
		threadPool.shutdown();
		//threadPool.shutdownNow();
		System.out.println("线程池关闭");

	}

}
