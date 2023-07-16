package com.lgcns.tct.proxy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class ProxyVoFactory {
	
	public static ProxyVo readProxy(String filePath) {

		Reader reader = null;
		ProxyVo proxyVo = null;

		try {
			reader = new FileReader(filePath);
			Gson gson = new Gson();
			proxyVo = gson.fromJson(reader, ProxyVo.class);
			
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
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
		
		return proxyVo;
	}

	public static void writeProxy(String filePath, ProxyVo proxyVo) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		FileWriter fw = null;
		try {
			fw = new FileWriter(filePath);
			gson.toJson(proxyVo, fw);
			fw.flush();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		// read json
		String filePath = "Proxy-2.json";
		ProxyVo proxyVo = ProxyVoFactory.readProxy(filePath);
		
		System.out.printf("Port: %d, \nUrl: %s \n", proxyVo.getPort(), proxyVo.getRoutes().get(0));
		
		// write json
		ProxyVo proxyVo2 = new ProxyVo();
		proxyVo2.setPort(10001);
		
		List routes = new ArrayList();
		Route route1 = new Route();
		route1.setPathPrefix("/carom");
		route1.setUrl("http://127.0.0.1:10101");
		routes.add(route1);
		
		Route route2 = new Route();
		route2.setPathPrefix("/pool");
		route2.setUrl("http://127.0.0.1:10201");
		routes.add(route2);
		
		proxyVo2.setRoutes(routes);
		
		ProxyVoFactory.writeProxy("Proxy-Billiard.json", proxyVo2);
		System.out.println("wrote new json");
		
	}

}
