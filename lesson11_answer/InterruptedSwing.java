package lesson11_answer;
import java.awt.*;

import javax.swing.*;

public class InterruptedSwing extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Thread thread;
	
	public static void main(String[] args) {
		init(new InterruptedSwing(), 200, 200);
	}
	
	public InterruptedSwing() {
		super();
		
		final JProgressBar progressBar = new JProgressBar(); // ����������
		// �������������ڴ������λ��
		getContentPane().add(progressBar, BorderLayout.NORTH);
		progressBar.setStringPainted(true); // ���ý���������ʾ����
		thread = new Thread(new Runnable() {
			int count = 0;
		//	boolean istrue = true;
			public void run() {
				while (true) {
					progressBar.setValue(++count); // ���ý������ĵ�ǰֵ
				//	System.out.println("�߳���ִ���С���");
					
					try {
						Thread.sleep(300); // ʹ�߳�����1000����
						// ��׽InterruptedException�쳣
					} catch (InterruptedException e) {
						System.out.println("��ǰ�߳����ж�");
						break;
					}
					
					if(count>=20)
					{												
						//thread.interrupt(); // �ж��߳�
						//break;
					}
					
					System.out.println("�߳��ж�״̬��"+thread.isInterrupted());
					
				}
				
			}
		});
		thread.start(); // �����߳�
		thread.interrupt(); // �ж��߳�
	}
	
	public static void init(JFrame frame, int width, int height) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(width, height);
		frame.setBounds(300,300,width,height);
		frame.setVisible(true);
	}
	
}
