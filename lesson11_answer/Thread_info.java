package lesson11_answer;
/**
 * 获取线程信息的相关方法
 * @author adminitartor
 *
 */
public class Thread_info {
	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		//获取线程唯一标识
		long id = main.getId();
		System.out.println("id:"+id);
		
		String name = main.getName();
		System.out.println("name:"+name);
		
		int priority = main.getPriority();
		System.out.println("优先级:"+priority);
		
		//线程是否活着
		boolean isAlive = main.isAlive();
		System.out.println("isAlive:"+isAlive);
		//是否为守护线程
		boolean isDaemon = main.isDaemon();
		System.out.println("isDaemon:"+isDaemon);
		//当前线程是否被中断
		boolean isInterrupted = main.isInterrupted();
		System.out.println("isInterrupted:"+isInterrupted);
		
	}
}






