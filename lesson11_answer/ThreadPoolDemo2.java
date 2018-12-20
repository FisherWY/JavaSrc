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
 * �ٷ�����������̳߳ص�ʵ��
 */

/**
 * Executors.newCachedThreadPool(); ��������̳߳�
 * ����һ���ɻ����̳߳أ�����̳߳س��ȳ���������Ҫ���������տ����̣߳����޿ɻ��գ����½��̡߳�
 * �̳߳�Ϊ���޴󣬵�ִ�еڶ�������ʱ��һ�������Ѿ���ɣ��Ḵ��ִ�е�һ��������̣߳�������ÿ���½��̡߳�
 */
class CatchThreadPoolDemo {
	public static void test01() {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(index * 1000);
				// System.out.println("����ʱ�߳�"+Runtime.getRuntime().availableProcessors());
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
 * ����һ�������̳߳أ��ɿ����߳���󲢷������������̻߳��ڶ����еȴ���ʾ���������£� �����̳߳صĴ�С��ø���ϵͳ��Դ�������á�
 * Runtime.getRuntime().availableProcessors();�ɻ�ȡϵͳ�Ļ�߳���
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
 * TimeUnit ö����ʱ�������� ����һ�������̳߳أ�֧�ֶ�ʱ������������ִ�С��ӳ�ִ��ʾ���������£�
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
 * Executors.newSingleThreadExecutor(); ����һ�����̻߳����̳߳أ���ֻ����Ψһ�Ĺ����߳���ִ������
 * ��֤����������ָ��˳��(FIFO, LIFO, ���ȼ�)ִ�С�
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
