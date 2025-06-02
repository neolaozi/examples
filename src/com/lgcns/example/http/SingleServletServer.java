package com.lgcns.example.http;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 *
 * 실행 예시 (curl)
 <pre>
	curl http://127.0.0.1:8080/search
	# {"result": "search ok"}
	
	curl http://127.0.0.1:8080/register
	# {"result": "register ok"}
	
	curl -X POST http://127.0.0.1:8080/detail
	# {"result": "detail ok"}
	
	curl http://127.0.0.1:8080/unknown
	# {"error": "Not Found"}
 </pre> 
 * @author R11692
 *
 */
public class SingleServletServer {
	public static void main(String[] args) throws Exception {
		Server server = new Server();
		ServerConnector connector = new ServerConnector(server);
		connector.setHost("127.0.0.1");
		connector.setPort(8080);
		server.addConnector(connector);

		ServletHandler handler = new ServletHandler();
		handler.addServletWithMapping(MainServlet.class, "/*"); // 모든 경로를 하나의 서블릿에 매핑
		server.setHandler(handler);

		server.start();
		server.join();
	}

	public static class MainServlet extends HttpServlet {
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			String path = req.getRequestURI();
			String method = req.getMethod();

			resp.setContentType("application/json");

			if ("/search".equals(path) && "GET".equalsIgnoreCase(method)) {
				resp.getWriter().println("{\"result\": \"search ok\"}");
			} else if ("/register".equals(path) && "GET".equalsIgnoreCase(method)) {
				resp.getWriter().println("{\"result\": \"register ok\"}");
			} else if ("/detail".equals(path) && "POST".equalsIgnoreCase(method)) {
				resp.getWriter().println("{\"result\": \"detail ok\"}");
			} else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				resp.getWriter().println("{\"error\": \"Not Found\"}");
			}
		}
	}
}