package com.lgcns.tct.proxy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ServiceProxy {

	public void runProxy(String proxyName) {
		BufferedReader reader = null;

		try {
			// proxy
			reader = new BufferedReader(new FileReader(proxyName + ".txt"));
			String routingRule = reader.readLine();

			// service
			reader = new BufferedReader(new FileReader(routingRule));
			String serviceName = reader.readLine();
			
			System.out.println(serviceName);
			
//			while (line != null) {
//				line = reader.readLine();
//			}

		} catch (IOException e) {
			e.printStackTrace(); 
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void runProxy(String proxyName, String pPath) {
		BufferedReader reader = null;

		try {
			// proxy
			reader = new BufferedReader(new FileReader(proxyName));
			String routingRule = null;
			
			while((routingRule = reader.readLine()) != null) {
				// debug
				// System.out.printf("routingRule:%s\n", routingRule);
	
				// if fileName�� "Proxy-"�� �����ϴ� ���
				if(routingRule.startsWith(pPath)) {
					String fileName = routingRule.split("#")[1];
					if(fileName.startsWith("Proxy-")) {
						runProxy(fileName, pPath);
					} else {
						reader = new BufferedReader(new FileReader(fileName));
						String serviceCall = reader.readLine();
						System.out.println(serviceCall);
					}
				} else {
					// debug
					// System.out.printf("routingRule:(%s) not start with %s\n", routingRule, pPath);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void run(String routingRule) {
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		String[] inputSplit = input.split(" ");
		runProxy(inputSplit[0] + ".txt", inputSplit[1]);
		
		
	}
	
	public static void main(String[] args) {
		

	}

}
