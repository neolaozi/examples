package com.lgcns.example.thread;

/* ������ ������ ���α׷�(���� 4) */
import java.util.ArrayList;
import java.util.Random;

public class ThreadTest extends Thread {
	// index ������ �߰��ؼ� �����尡 ���۽ÿ� �ش� ������ ������Ű���� �Ұ̴ϴ�.
	private static int index = 0;

	private int id = -1;

	public ThreadTest(int id) {
		this.id = id;
	}

	public void run() {
		System.out.println(id + "�� ������ ���� ��...");
		Random r = new Random(System.currentTimeMillis());
		try {
			long s = r.nextInt(3000); // 3�ʳ��� ������.
			Thread.sleep(s); // �����带 ��� ����
			setIndex();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(id + "�� ������ ���� ����...");
	}

	public synchronized static void setIndex() {
		index++; // index ������ ������ŵ�ϴ�.
	}

	public static void main(String[] args) {

		System.out.println("Start main method.");

		ArrayList<Thread> threadList = new ArrayList<Thread>();

		for (int i = 0; i < 10; i++) {
			ThreadTest test = new ThreadTest(i);

			test.start(); // �� �޼ҵ带 �����ϸ� Thread ���� run()�� �����Ѵ�.
			threadList.add(test); // ������ �����带 ����Ʈ�� ����
		}

		for (int i = 0; i < threadList.size(); i++) {
			try {
				threadList.get(i).join(); // �������� ó���� ���������� ��ٸ��ϴ�.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("current Index: " + index); // index�� ���� ��ȯ�մϴ�.
		System.out.println("End main method.");
	}
}
