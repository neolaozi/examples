package com.lgcns.tct.proxy;

import java.util.ArrayList;
import java.util.List;

public class ProxyVo {

	private int port;
	
	private List routes = new ArrayList();
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public List getRoutes() {
		return routes;
	}

	public void setRoutes(List routes) {
		this.routes = routes;
	}
}

class Route {
	private String pathPrefix;
	private String url;
	
	public String getPathPrefix() {
		return pathPrefix;
	}
	public void setPathPrefix(String pathPrefix) {
		this.pathPrefix = pathPrefix;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		
		return String.format("pathPrefix: %s, \nurl: %s \n", pathPrefix, url);
	}
	
	
}