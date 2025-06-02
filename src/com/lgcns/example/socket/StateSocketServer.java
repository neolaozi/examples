package com.lgcns.example.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class StateSocketServer {
	public static void main(String[] args) {
		int port = 9090;
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try (ServerSocket serverSocket = new ServerSocket(port)) {
			System.out.println("서버가 9090 포트에서 대기중...");

			while (true) {
				try (Socket clientSocket = serverSocket.accept();
						ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream())) {

					Object obj = ois.readObject();
					if (obj instanceof StateFile) {
						StateFile stateFile = (StateFile) obj;
						String json = gson.toJson(stateFile);
						System.out.println("수신된 객체를 JSON으로 변환:");
						System.out.println(json);
					} else {
						System.out.println("알 수 없는 객체를 수신했습니다.");
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
