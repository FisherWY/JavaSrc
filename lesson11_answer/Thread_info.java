package lesson11_answer;
/**
 * ��ȡ�߳���Ϣ����ط���
 * @author adminitartor
 *
 */
public class Thread_info {
	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		//��ȡ�߳�Ψһ��ʶ
		long id = main.getId();
		System.out.println("id:"+id);
		
		String name = main.getName();
		System.out.println("name:"+name);
		
		int priority = main.getPriority();
		System.out.println("���ȼ�:"+priority);
		
		//�߳��Ƿ����
		boolean isAlive = main.isAlive();
		System.out.println("isAlive:"+isAlive);
		//�Ƿ�Ϊ�ػ��߳�
		boolean isDaemon = main.isDaemon();
		System.out.println("isDaemon:"+isDaemon);
		//��ǰ�߳��Ƿ��ж�
		boolean isInterrupted = main.isInterrupted();
		System.out.println("isInterrupted:"+isInterrupted);
		
	}
}






