package lesson11_answer;
import java.awt.*;

import javax.swing.*;

public class ThreadJoinTest extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Thread threadA; // ���������߳�
	private Thread threadB;
	private boolean tbhadStart= false;
	final JProgressBar progressBar = new JProgressBar(); // �����������������
	final JProgressBar progressBar2 = new JProgressBar();
	int count = 0;
	
	public static void main(String[] args) {
		init(new ThreadJoinTest(), 200, 200);
	}
	
	public ThreadJoinTest() {
		super();
		// �������������ڴ������
		getContentPane().add(progressBar, BorderLayout.NORTH);
		// �������������ڴ���������
		getContentPane().add(progressBar2, BorderLayout.SOUTH);
		progressBar.setStringPainted(true); // ���ý�������ʾ�����ַ�
		progressBar2.setStringPainted(true);
		// ʹ�������ڲ�����ʽ��ʼ��Threadʵ����
		threadA = new Thread(new Runnable() {
			int count = 0;
			
			public void run() { // ��дrun()����
				while (true) {
					progressBar.setValue(++count); // ���ý������ĵ�ǰֵ	
					if(tbhadStart)
					{
					System.out.println(threadB.isAlive());
					tbhadStart=false;
					}
					try {
						Thread.sleep(100); // ʹ�߳�A����100����
						threadB.join(); // ʹ�߳�B����join()����
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(count==100)
					{
						break;
					}
				}
			}
		});
		threadA.start(); // �����߳�A
		
		threadB = new Thread(new Runnable() {
			int count = 0;
			
			public void run() {
				while (true) {
					progressBar2.setValue(++count); // ���ý������ĵ�ǰֵ
					try {
						Thread.sleep(100); // ʹ�߳�B����100����
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					if (count == 100) // ��count��������Ϊ100ʱ
						
						break; // ����ѭ��
				}
				
			}
		});
		threadB.start(); // �����߳�B
	}
	
	// ���ô���������Է���
	public static void init(JFrame frame, int width, int height) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(width, height);
		 frame.setBounds(300,250,width,height);
		frame.setVisible(true);
	}
}
