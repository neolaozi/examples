package com.lgcns.example.tct;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Example from TCT SUB5
 * @author 72318
 */
public class LogAnalyzer {

	private static LogAnalyzer instance = new LogAnalyzer();

	public static LogAnalyzer getInstance() {
		return instance;
	}

	public void analyzeFile(String fileName, List<String> patternList, String reportfileName) {

		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
		
		// "LOGFILE_A.TXT";
		BufferedReader br = null;
		BufferedWriter bw = null;

		if (patternList != null && patternList.size() > 10)
			throw new RuntimeException("too many pattern to find");

		try {
			String line = null;

			br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));

			Map<String, Integer> countMap = new HashMap<String, Integer>();

			while ((line = br.readLine()) != null) {
				// sb.append(line);
				// sb.append(System.lineSeparator());
				String[] splitArr = line.split("#");
				for (String pattern : patternList) {
					if (splitArr[1].indexOf(pattern) != -1) {
						countMap.merge(pattern, 1, Integer::sum);
						
						// writeToFile(line, pattern);
						fixedThreadPool.execute(new WriteFileThread(line, pattern));
					}
				}
			}

			bw = new BufferedWriter(new FileWriter(reportfileName, false));
			for (String pattern : patternList) {
				bw.write(pattern + "#" + countMap.get(pattern));
				bw.newLine();
			}
			
			fixedThreadPool.awaitTermination(5, TimeUnit.SECONDS);
			fixedThreadPool.shutdown();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} catch (InterruptedException e) {
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
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				bw = null;
			}
		}

	}

	public void writeToFile(String msgLine, String pattern) {
		String[] split = msgLine.split("#");
		List<String> cmd = new ArrayList<String>();
		cmd.add("CODECONV.EXE");
		cmd.add(split[2]);

		ProcessBuilder builder = new ProcessBuilder(cmd);
		BufferedWriter bw = null;
		BufferedReader br = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("TYPELOG_5_" + pattern + ".TXT", true));
			bw.write(split[0] + "#" + split[1] + "#");
			
			InputStream is = builder.start().getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			String readLine = null;
			while((readLine = br.readLine()) != null) {
				bw.write(readLine);
			}
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				bw = null;
			}
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
class WriteFileThread extends Thread {
	
	private String msgLine;
	private String pattern;
	public WriteFileThread(String msgLine, String pattern){
		this.msgLine = msgLine;
		this.pattern = pattern;
    }
	
	@Override
	public void run() {
		super.run();
		String[] split = msgLine.split("#");
		List<String> cmd = new ArrayList<String>();
		cmd.add("CODECONV.EXE");
		cmd.add(split[2]);

		StringBuilder strBuilder = new StringBuilder();
		ProcessBuilder builder = new ProcessBuilder(cmd);
		BufferedWriter bw = null;
		BufferedReader br = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("TYPELOG_5_" + pattern + ".TXT", true));
			strBuilder.append(split[0] + "#" + split[1] + "#");
			
			InputStream is = builder.start().getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			String readLine = null;
			while((readLine = br.readLine()) != null) {
				strBuilder.append(readLine);
			}
			
			strBuilder.append(System.lineSeparator());
			bw.write(strBuilder.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				bw = null;
			}
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