package io.kubesphere.sig.demo.web;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleWeb {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("", 8080), 0);
        server.createContext("/hello", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                final String simpleContent = "hellO";

                try (OutputStream out = exchange.getResponseBody()) {
                    exchange.sendResponseHeaders(200, simpleContent.length());
                    out.write(simpleContent.getBytes());
                }
            }
        });
        server.start();
    }
}
