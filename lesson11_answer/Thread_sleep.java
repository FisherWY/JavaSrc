package lesson11_answer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * �߳��ṩ��һ����̬����
 * static void sleep(long ms)
 * �÷����Ὣ���е�ǰ�������߳�����ָ�����롣
 * @author adminitartor
 *
 */
public class Thread_sleep {
	public static void main(String[] args) {
		/*
		 * ʵ�ֵ��ӱ���
		 * ÿ�����ڿ���̨�����ǰϵͳʱ�䣬��ʽ:
		 * 16:55:32
		 */
		SimpleDateFormat sdf
			= new SimpleDateFormat("HH:mm:ss");
		
		while(true){
			System.out.println(sdf.format(new Date()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
	}
}







