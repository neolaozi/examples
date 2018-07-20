package com.lgcns.example.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileReaderTest {

	public static void main(String args[]) throws Exception {

		String fileName = "../LOGFILE_A.TXT";
		BufferedReader br = null;

		try {
			String line = null;
			StringBuilder sb = new StringBuilder();

			br = new BufferedReader(
					new InputStreamReader(new FileInputStream(new File(fileName)), StandardCharsets.UTF_8));

			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
			}

			System.out.println(sb);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				br = null;
			}
		}

	}
}
