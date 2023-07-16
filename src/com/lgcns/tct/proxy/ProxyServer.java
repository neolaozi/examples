package com.lgcns.tct.proxy;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class ProxyServer {

	private ProxyVo config = null;

	public ProxyServer(ProxyVo config) {
		this.config = config;
	}
	
	public void start() throws Exception {

		Server server = new Server();
        ServerConnector http = new ServerConnector(server);
//        http.setHost("127.0.0.1");
//        http.setPort(8080);
        http.setHost("127.0.0.1");
        http.setPort(this.config.getPort());
        server.addConnector(http);

        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addServletWithMapping(ProxyServlet.class, "/*");
        server.setHandler(servletHandler);

        server.start();
        server.join(); 
	}
	
	public static void main(String[] args) {
		
		ProxyVo vo = ProxyVoFactory.readProxy("Proxy-1.json");
		ProxyServer server = new ProxyServer(vo);

	}

}
