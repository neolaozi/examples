package com.lgcns.example.scanner;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ScannerClient implements Runnable {

	private String ipAddr = null;
	private int port = 0;

	public ScannerClient(String ipAddr, int port) {
		super();
		this.ipAddr = ipAddr;
		this.port = port;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public void run() {

		Socket soc = null;
		BufferedWriter bw = null;
		Scanner svrScan = null;
		Scanner keyScan = null;

		// 1. socket connect
		try {
			soc = new Socket(this.ipAddr, port);
		} catch (UnknownHostException e) {
			throw new RuntimeException("[ERROR] UnknownHostException while creating Socket", e);
		} catch (IOException e) {
			throw new RuntimeException("[ERROR] IOException while creating Socket", e);
		} 
		
		// 2. scanner ()
		try {
			svrScan = new Scanner(soc.getInputStream());
			keyScan = new Scanner(System.in);
		} catch (IOException e) {
			throw new RuntimeException("[ERROR] IOException while creating Scanner", e);
		}

		// 3. writer ()
		try {
			bw = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));

			System.out.print("Please Key in Your command : ");
			int read_1_int = keyScan.nextInt();
			
			// TODO logic here...
			System.out.print("Logic...");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {

	}

}
