package com.lgcns.example.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPoolSocketServer {
	// 연결할 포트를 지정합니다.
	private static final int PORT = 8080;
	// 스레드 풀의 최대 스레드 개수를 지정합니다.
	private static final int THREAD_CNT = 5;
	private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_CNT);

	public static void main(String[] args) {

		try {
			// 서버소켓 생성
			ServerSocket serverSocket = new ServerSocket(PORT);

			// 소켓서버가 종료될때까지 무한루프
			while (true) {
				// 소켓 접속 요청이 올때까지 대기합니다.
				Socket socket = serverSocket.accept();
				try {
					// 요청이 오면 스레드 풀의 스레드로 소켓을 넣어줍니다.
					// 이후는 스레드 내에서 처리합니다.
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

// 소켓 처리용 래퍼 클래스입니다.
class ConnectionWrap implements Runnable {

	private Socket socket = null;

	public ConnectionWrap(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		try {
			// 응답을 위해 스트림을 얻어옵니다.
			OutputStream stream = socket.getOutputStream();
			// 그리고 현재 날짜를 출력해줍니다.
			stream.write(new Date().toString().getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close(); // 반드시 종료합니다.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}