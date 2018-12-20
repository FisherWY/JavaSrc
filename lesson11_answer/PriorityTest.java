package lesson11_answer;
import java.awt.*;

import javax.swing.*;

public class PriorityTest extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Thread threadA;
	private Thread threadB;
	private Thread threadC;
	private Thread threadD;
	private Thread threadE;
	private Thread threadF;
	private Thread threadG;
	
	public PriorityTest() {
		getContentPane().setLayout(new GridLayout(7, 1));
		// 分别实例化4个线程
		final JProgressBar progressBar = new JProgressBar();
		final JProgressBar progressBar2 = new JProgressBar();
		final JProgressBar progressBar3 = new JProgressBar();
		final JProgressBar progressBar4 = new JProgressBar();
		final JProgressBar progressBar5 = new JProgressBar();
		final JProgressBar progressBar6 = new JProgressBar();
		final JProgressBar progressBar7 = new JProgressBar();
		
		getContentPane().add(progressBar);
		getContentPane().add(progressBar2);
		getContentPane().add(progressBar3);
		getContentPane().add(progressBar4);
		getContentPane().add(progressBar5);
		getContentPane().add(progressBar6);
		getContentPane().add(progressBar7);
		
		progressBar.setStringPainted(true);
		progressBar2.setStringPainted(true);
		progressBar3.setStringPainted(true);
		progressBar4.setStringPainted(true);
		progressBar5.setStringPainted(true);
		progressBar6.setStringPainted(true);
		progressBar7.setStringPainted(true);
		
		threadA = new Thread(new MyThread(progressBar));
		threadB = new Thread(new MyThread(progressBar2));
		threadC = new Thread(new MyThread(progressBar3));
		threadD = new Thread(new MyThread(progressBar4));
		threadE = new Thread(new MyThread(progressBar5));
		threadF = new Thread(new MyThread(progressBar6));
		threadG = new Thread(new MyThread(progressBar7));
		
		setPriority("threadA", 10, threadA);
		setPriority("threadB", 1, threadB);
		setPriority("threadC", 10, threadC);
		setPriority("threadD", 10, threadD);
		setPriority("threadE", 10, threadE);
		setPriority("threadF", 10, threadF);
		setPriority("threadG", 10, threadG);
	}
	
	// 定义设置线程的名称、优先级的方法
	public static void setPriority(String threadName, int priority,
			Thread t) {
		t.setPriority(priority); // 设置线程的优先级
		t.setName(threadName); // 设置线程的名称
		t.start(); // 启动线程
	}
	
	public static void main(String[] args) {
		init(new PriorityTest(), 300, 300);
	}
	
	public static void init(JFrame frame, int width, int height) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(width, height);
		frame.setBounds(300,250,width,height);
		frame.setVisible(true);
	}
	
	private final class MyThread implements Runnable { // 定义一个实现Runnable接口的类
		private final JProgressBar bar;
		int count = 0;
		
		private MyThread(JProgressBar bar) {
			this.bar = bar;
		}
		
		public void run() { // 重写run()方法
			while (true) {
				bar.setValue(count += 1); // 设置滚动条的值每次自增10
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println("当前线程序被中断");
				}
			}
		}
	}
	
}
