package lesson11_answer;
/**
 * �߳����ȼ�
 * �����̵߳��ȵĹ������̲߳��ܸ��棬�����߳�ֻ�ܱ���
 * �ĵȴ�����CPUʱ��Ƭ��������������ȡ��
 * ����ͨ���޸��߳����ȼ������̶ȸ��ƻ�ȡCPUʱ��Ƭ
 * �ļ��ʣ������ϣ��߳����ȼ�Խ�ߵ��̻߳�ȡCPUʱ��Ƭ
 * �Ĵ���Խ�ࡣ
 * �̵߳����ȼ���10���ȼ����ֱ�������1-10��ʾ��
 * ����1��ͣ�10��ߣ�5ΪĬ��ֵ��
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













