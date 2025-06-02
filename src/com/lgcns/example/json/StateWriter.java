package com.lgcns.example.json;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class StateWriter {
	public static void main(String[] args) {
		// 객체 생성
		StateFile stateFile = new StateFile();
		stateFile.state = new LinkedHashMap<>();

		StateAction create = new StateAction();
		create.type = "action";
		create.url = "http://127.0.0.1:8081/create";
		create.parameters = Arrays.asList("id");

		StateAction add = new StateAction();
		add.type = "action";
		add.url = "http://127.0.0.1:8082/add";
		add.parameters = Arrays.asList("id", "key", "data", "plus");

		StateAction fetch = new StateAction();
		fetch.type = "action";
		fetch.url = "http://127.0.0.1:8083/fetch";
		fetch.parameters = Collections.emptyList();

		stateFile.state.put("create", create);
		stateFile.state.put("add", add);
		stateFile.state.put("fetch", fetch);

		// JSON 파일로 저장
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String filePath = "D:\\\\git-neolaozi\\\\examples\\\\src\\\\STATE.JSON";

		try (FileWriter writer = new FileWriter(filePath)) {
			gson.toJson(stateFile, writer);
			System.out.println("STATE.JSON 파일로 저장 완료!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}