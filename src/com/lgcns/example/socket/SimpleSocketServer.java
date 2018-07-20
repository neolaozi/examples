package com.lgcns.example.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleSocketServer {
	
	// ������ ��Ʈ�� �����մϴ�.
	private static final int PORT = 8080;

	public static void main(String[] args) {

		try {
			// �������� ����
			ServerSocket serverSocket = new ServerSocket(PORT);

			// ���ϼ����� ����ɶ����� ���ѷ���
			while (true) {
				// ���� ���� ��û�� �ö����� ����մϴ�.
				Socket socket = serverSocket.accept();
				try {
					// ������ ���� ��Ʈ���� ���ɴϴ�.
					OutputStream stream = socket.getOutputStream();
					// �׸��� ���� ��¥�� ������ݴϴ�.
					stream.write(new Date().toString().getBytes());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// �ݵ�� ������ �ݽ��ϴ�.
					socket.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}