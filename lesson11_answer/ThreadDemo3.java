package lesson11_answer;
/**
 * �������ڲ�������̵߳����ַ�ʽ����
 * @author adminitartor
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		//��ʽһ
		new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("����˭����");
				}
			}
		}.start();
		
		new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("���ǲ�ˮ���!");
				}
			}
		}).start();
	
	}
}


