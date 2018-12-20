package lesson11_answer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;

public class ThreadPoolDemo2 {

	public static void main(String[] args) {

		// CatchThreadPoolDemo.test01();
		ScheduledThreadPoolDemo.test03();

	}

}

/**
 * 官方建议的四种线程池的实现
 */

/**
 * Executors.newCachedThreadPool(); 带缓冲的线程池
 * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
 */
class CatchThreadPoolDemo {
	public static void test01() {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(index * 1000);
				// System.out.println("运行时线程"+Runtime.getRuntime().availableProcessors());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println(index);
				}
			});
		}
	}
}

/**
 * Executors.newFixedThreadPool(int n);
 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。示例代码如下： 定长线程池的大小最好根据系统资源进行设置。
 * Runtime.getRuntime().availableProcessors();可获取系统的活动线程数
 */

class FixThreadPoolDemo {
	public static void test02(String[] args) {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					try {
						System.out.println(index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}

/**
 * Executors.newScheduledThreadPool(Runnable r,long n,TimeUnit timeUnit);
 * TimeUnit 枚举提时间间隔常量 创建一个定长线程池，支持定时及周期性任务执行。延迟执行示例代码如下：
 */

class ScheduledThreadPoolDemo {
	public static void test03() {
		ScheduledExecutorService scheduledThreadPool = Executors
				.newScheduledThreadPool(5);

		Runnable run = new Runnable() {
			public void run() {
				System.out.println("delay ? seconds");
			}
		};
		// scheduledThreadPool.schedule(run , 3, TimeUnit.SECONDS);
		scheduledThreadPool.scheduleAtFixedRate(run, 1, 2, TimeUnit.SECONDS);

	}
}

// newSingleThreadExecutor
/**
 * Executors.newSingleThreadExecutor(); 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，
 * 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 */

class SingleThreadThreadPool {
	public static void test(String[] args) {
		ExecutorService singleThreadExecutor = Executors
				.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			singleThreadExecutor.execute(new Runnable() {
				public void run() {
					try {
						System.out.println(index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}
