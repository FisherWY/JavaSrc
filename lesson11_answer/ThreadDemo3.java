package lesson11_answer;
/**
 * 用匿名内部类完成线程的两种方式创建
 * @author adminitartor
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		//方式一
		new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("你是谁啊？");
				}
			}
		}.start();
		
		new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("我是查水表的!");
				}
			}
		}).start();
	
	}
}


