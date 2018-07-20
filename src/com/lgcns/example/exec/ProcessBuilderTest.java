package com.lgcns.example.exec;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProcessBuilderTest {

	public static void main(String[] args) {

		List<String> cmd = new ArrayList<String>();
		System.out.printf("file exists: %b\n", new File("C:/ssp_workspace/ssp_java_test/java-utils/CODECONV.EXE").exists());;
		cmd.add("C:/ssp_workspace/ssp_java_test/java-utils/CODECONV.EXE");
		cmd.add("AAABBBCCC");

		ProcessBuilder builder = new ProcessBuilder(cmd);
		InputStream is = null;
		try {
			is = builder.start().getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String readLine = null;
			System.out.printf("before readLine\n");
			
			while ((readLine = br.readLine()) != null) {
			    System.out.println(readLine);
			}

/*			
			while ((readLine = br.readLine()) != null) {
				System.out.printf("readLine : %s\n", readLine);
			}
*/			
			System.out.printf("after readLine\n");

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				is = null;
			}
		}

	}

}
