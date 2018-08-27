package com.lgcns.example.scanner;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScannerServer implements Runnable {

	/**
	 * for Test
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

	}

	// Switch to SocketServer Run/Shutdown
	private boolean hasToRun = true;
	private int port = 0;
	private int threadCount = 0;
	private ExecutorService pool = null;

	public ScannerServer(int port, int threadCount) {
		super();
		this.port = port;
		this.threadCount = threadCount;
		this.pool = Executors.newFixedThreadPool(threadCount);
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(int threadCount) {
		this.threadCount = threadCount;
	}

	public boolean isHasToRun() {
		return hasToRun;
	}

	public void setHasToRun(boolean hasToRun) {
		this.hasToRun = hasToRun;
	}

	@Override
	public void run() {
		ServerSocket svrSoc = null;
		Socket receiverSocket = null;
		try {
			svrSoc = new ServerSocket(port);
		} catch (IOException e) {
			throw new RuntimeException("[ERROR] Problem occurred, while ServerSocket creation", e);
		}

		Socket soc = null;

		while (hasToRun) {
			try {
				soc = svrSoc.accept();
			} catch (IOException e) {
				throw new RuntimeException("[ERROR] Problem occurred, while socket.accept", e);
			}
			pool.submit(new ReceiverThread(soc));
		}

		if (svrSoc != null) {
			try {
				svrSoc.close();
				svrSoc = null;
			} catch (IOException e) {
				throw new RuntimeException("[ERROR] Problem occurred, while socket.accept", e);
			}
		}
	}

}

class ReceiverThread implements Runnable {

	private Socket socket = null;

	public ReceiverThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(socket.getInputStream());

			// TODO logic
			int command = scanner.nextInt();
			switch (command) {

			case 1:
				System.out.printf("case 1");
			case 2:
				System.out.printf("case 2");
			default:
				System.out.printf(", command: %d\n", command);

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
				scanner = null;
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				socket = null;
			}
		}
	}

}
