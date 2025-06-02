package com.lgcns.example.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DeviceInfoLoader {
	public static void main(String[] args) {
		String filePath = "DEVICE_INFO.TXT";
		Map<String, String> deviceMap = new HashMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (line.isEmpty())
					continue; // 빈 줄 무시
				int idx = line.indexOf('#');
				if (idx > 0 && idx < line.length() - 1) {
					String key = line.substring(0, idx).trim();
					String value = line.substring(idx + 1).trim();
					deviceMap.put(key, value);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 결과 출력 (테스트용)
		for (Map.Entry<String, String> entry : deviceMap.entrySet()) {
			System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
		}
	}
}
