package com.acgist.esceurekagateway;

import java.io.IOException;
import java.net.URI;

import org.junit.Test;
import org.springframework.http.MediaType;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpRequest.BodyPublisher;
import jdk.incubator.http.HttpResponse;

/**
 * JAVA9+
 * --add-modules jdk.incubator.httpclient
 */
public class MainTest {

	@Test
	public void request() throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
//		HttpRequest get = HttpRequest.newBuilder(URI.create("http://localhost:5555/admin/login?token=token")).header("accept", MediaType.TEXT_HTML_VALUE).GET().build();
		HttpRequest get = HttpRequest.newBuilder(URI.create("http://localhost:5555/admin/login?token=token")).header("accept", MediaType.APPLICATION_JSON_VALUE).GET().build();
//		HttpRequest get = HttpRequest.newBuilder(URI.create("http://localhost:5555/acgist?token=token")).header("accept", MediaType.TEXT_HTML_VALUE).GET().build();
//		HttpRequest get = HttpRequest.newBuilder(URI.create("http://localhost:5555/acgist?token=token")).header("accept", MediaType.APPLICATION_JSON_VALUE).GET().build();
//		HttpRequest get = HttpRequest.newBuilder(URI.create("http://localhost:5555/service/acgist?token=token")).header("accept", MediaType.TEXT_HTML_VALUE).GET().build();
//		HttpRequest get = HttpRequest.newBuilder(URI.create("http://localhost:5555/service/acgist?token=token")).header("accept", MediaType.APPLICATION_JSON_VALUE).GET().build();
//		HttpRequest get = HttpRequest.newBuilder(URI.create("http://localhost:5555/service/acgist?token=token")).header("accept", MediaType.APPLICATION_XML_VALUE).GET().build();
		HttpResponse<String> resp = client.send(get, HttpResponse.BodyHandler.asString());
		System.out.println(resp);
		System.out.println(resp.statusCode());
		System.out.println(resp.body());
	}
	
	/**
	 * 动态刷新配置
	 */
	@Test
	public void refresh() throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest post = HttpRequest.newBuilder(URI.create("http://localhost:5555/actuator/refresh")).header("accept", MediaType.APPLICATION_JSON_VALUE).POST(BodyPublisher.fromString("")).build();
		HttpResponse<String> resp = client.send(post, HttpResponse.BodyHandler.asString());
		System.out.println(resp);
	}
	
	/**
	 * 动态刷新配置
	 */
	@Test
	public void busRefresh() throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest post = HttpRequest.newBuilder(URI.create("http://localhost:5555/actuator/bus-refresh")).header("accept", MediaType.APPLICATION_JSON_VALUE).POST(BodyPublisher.fromString("")).build();
//		注意转义
//		HttpRequest post = HttpRequest.newBuilder(URI.create("http://localhost:5555/actuator/bus-refresh/esc-eureka-gateway%3a5555")).header("accept", MediaType.APPLICATION_JSON_VALUE).POST(BodyPublisher.fromString("")).build();
//		HttpRequest post = HttpRequest.newBuilder(URI.create("http://localhost:5555/actuator/bus-refresh/esc-eureka-gateway%3a**")).header("accept", MediaType.APPLICATION_JSON_VALUE).POST(BodyPublisher.fromString("")).build();
		HttpResponse<String> resp = client.send(post, HttpResponse.BodyHandler.asString());
		System.out.println(resp);
	}
	
	/**
	 * 服务下线
	 */
	@Test
	public void shutdown() throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest post = HttpRequest.newBuilder(URI.create("http://localhost:5555/actuator/shutdown")).header("accept", MediaType.APPLICATION_JSON_VALUE).POST(BodyPublisher.fromString("")).build();
		HttpResponse<String> resp = client.send(post, HttpResponse.BodyHandler.asString());
		System.out.println(resp);
		System.out.println(resp.body());
	}
	
	/**
	 * 服务下线
	 */
	@Test
	public void user() throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest get = HttpRequest.newBuilder(URI.create("http://localhost:5555/admin/user")).header("accept", MediaType.APPLICATION_JSON_VALUE).GET().build();
		HttpResponse<String> resp = client.send(get, HttpResponse.BodyHandler.asString());
		System.out.println(resp);
		System.out.println(resp.body());
	}

}
