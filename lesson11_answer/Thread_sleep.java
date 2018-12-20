package lesson11_answer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程提供了一个静态方法
 * static void sleep(long ms)
 * 该方法会将运行当前方法的线程阻塞指定毫秒。
 * @author adminitartor
 *
 */
public class Thread_sleep {
	public static void main(String[] args) {
		/*
		 * 实现电子表功能
		 * 每秒钟在控制台输出当前系统时间，格式:
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







