package com.lgcns.example.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SimpleSocketClient {
	// ������ ��Ʈ�� �����մϴ�.
	private static final int PORT = 8080;

	public static void main(String[] args) {
		try {
			// ������ �����մϴ�.
			Socket socket = new Socket("localhost", PORT);
			// ��Ʈ���� ���ɴϴ�.
			InputStream stream = socket.getInputStream();
			// ��Ʈ���� �����մϴ�.
			BufferedReader br = new BufferedReader(new InputStreamReader(stream));
			// ����� �н��ϴ�.
			String response = br.readLine();
			System.out.println(response); // ����� ���

			socket.close(); // ������ �ݽ��ϴ�.
			System.exit(0); // ���α׷� ����

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}