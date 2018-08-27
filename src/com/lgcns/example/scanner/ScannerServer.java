package com.lgcns.example.scanner;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
