package com.lgcns.example.socket;

import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//데이터 구조 정의
@SuppressWarnings("serial")
class StateFile implements Serializable {
	public Map<String, StateAction> state;
}

@SuppressWarnings("serial")
class StateAction implements Serializable {
	public String type;
	public String url;
	public List<String> parameters;
}

public class StateSocketClient {
	public static void main(String[] args) {
		String filePath = "D:\\git-neolaozi\\examples\\src\\STATE.JSON";
		String host = "127.0.0.1";
		int port = 9090;

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try (FileReader reader = new FileReader(filePath)) {
			StateFile stateFile = gson.fromJson(reader, StateFile.class);

			try (Socket socket = new Socket(host, port);
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {
				oos.writeObject(stateFile);
				oos.flush();
				System.out.println("객체를 서버로 전송했습니다.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
