package com.lgcns.example.scanner;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

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
				scanner.nextLine();
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