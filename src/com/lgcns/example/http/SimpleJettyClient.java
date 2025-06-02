package com.lgcns.example.http;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpMethod;

public class SimpleJettyClient {
	public static void main(String[] args) throws Exception {
		HttpClient client = new HttpClient();
		client.start();

		// 1. /search GET 요청
		ContentResponse searchResponse = client.newRequest("http://127.0.0.1:8080/search")
				.method(HttpMethod.GET)
				.send();
		System.out.println("/search GET: " + searchResponse.getContentAsString());

		// 2. /register GET 요청
		ContentResponse registerResponse = client.newRequest("http://127.0.0.1:8080/register")
				.method(HttpMethod.GET)
				.send();
		System.out.println("/register GET: " + registerResponse.getContentAsString());

		// 3. /detail POST 요청
		ContentResponse detailResponse = client.newRequest("http://127.0.0.1:8080/detail")
				.method(HttpMethod.POST)
				.send();
		System.out.println("/detail POST: " + detailResponse.getContentAsString());

		client.stop();
	}
}