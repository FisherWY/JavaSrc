package lesson11_answer;
/**
 * 线程优先级
 * 对于线程调度的工作，线程不能干涉，即：线程只能被动
 * 的等待分配CPU时间片，而不能主动获取。
 * 可以通过修改线程优先级来最大程度改善获取CPU时间片
 * 的几率，理论上，线程优先级越高的线程获取CPU时间片
 * 的次数越多。
 * 线程的优先级有10个等级，分别用整数1-10表示。
 * 其中1最低，10最高，5为默认值。
 * 
 * @author adminitartor
 *
 */
public class Thread_setPriority {
	public static void main(String[] args) {
		Thread max = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("max");
				}
			}
		};
		Thread min = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("min");
				}
			}
		};
		Thread nor = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("nor");
				}
			}
		};
		
		max.setPriority(Thread.MAX_PRIORITY);
		min.setPriority(Thread.MIN_PRIORITY);
		
		min.start();
		nor.start();
		max.start();
		
	}
}













