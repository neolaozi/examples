package com.lgcns.example.json;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//데이터 구조 정의
class StateFile {
	public Map<String, StateAction> state;
}

class StateAction {
	public String type;
	public String url;
	public List<String> parameters;
}

public class StateReader {
	public static void main(String[] args) {
		String filePath = "D:\\git-neolaozi\\examples\\src\\STATE.JSON";
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try (FileReader reader = new FileReader(filePath)) {
			StateFile stateFile = gson.fromJson(reader, StateFile.class);

			// 객체 출력 (테스트용)
			for (Map.Entry<String, StateAction> entry : stateFile.state.entrySet()) {
				System.out.println("Action: " + entry.getKey());
				System.out.println("  Type: " + entry.getValue().type);
				System.out.println("  URL: " + entry.getValue().url);
				System.out.println("  Parameters: " + entry.getValue().parameters);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}