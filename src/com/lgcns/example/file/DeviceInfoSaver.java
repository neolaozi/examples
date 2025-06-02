package com.lgcns.example.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DeviceInfoSaver {
	public static void main(String[] args) {
		// 예시 Map 생성
		Map<String, String> deviceMap = new HashMap<>();
		deviceMap.put("1001", "abc");
		deviceMap.put("1002", "abd");
		deviceMap.put("1003", "abe");
		deviceMap.put("1101", "bbc");
		deviceMap.put("1102", "bbd");

		String filePath = "DEVICE_INFO.TXT";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			for (Map.Entry<String, String> entry : deviceMap.entrySet()) {
				writer.write(entry.getKey() + "#" + entry.getValue());
				writer.newLine();
			}
			System.out.println("파일 저장 완료: " + filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
