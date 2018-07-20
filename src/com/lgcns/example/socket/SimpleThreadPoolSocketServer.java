package com.lgcns.example.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPoolSocketServer {
	// ������ ��Ʈ�� �����մϴ�.
	private static final int PORT = 8080;
	// ������ Ǯ�� �ִ� ������ ������ �����մϴ�.
	private static final int THREAD_CNT = 5;
	private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_CNT);

	public static void main(String[] args) {

		try {
			// �������� ����
			ServerSocket serverSocket = new ServerSocket(PORT);

			// ���ϼ����� ����ɶ����� ���ѷ���
			while (true) {
				// ���� ���� ��û�� �ö����� ����մϴ�.
				Socket socket = serverSocket.accept();
				try {
					// ��û�� ���� ������ Ǯ�� ������� ������ �־��ݴϴ�.
					// ���Ĵ� ������ ������ ó���մϴ�.
					threadPool.execute(new ConnectionWrap(socket));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

// ���� ó���� ���� Ŭ�����Դϴ�.
class ConnectionWrap implements Runnable {

	private Socket socket = null;

	public ConnectionWrap(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		try {
			// ������ ���� ��Ʈ���� ���ɴϴ�.
			OutputStream stream = socket.getOutputStream();
			// �׸��� ���� ��¥�� ������ݴϴ�.
			stream.write(new Date().toString().getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close(); // �ݵ�� �����մϴ�.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}