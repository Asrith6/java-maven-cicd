
package com.example;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class App {

    static final int PORT = 8081;

    static final String RESPONSE_MESSAGE =
            "Hello! Maven CI/CD Pipeline";

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(
                new InetSocketAddress("0.0.0.0", PORT), 0
        );

        server.createContext("/", exchange -> {

            byte[] responseBytes =
                    RESPONSE_MESSAGE.getBytes(StandardCharsets.UTF_8);

            exchange.getResponseHeaders()
                    .set("Content-Type", "text/plain; charset=UTF-8");

            exchange.sendResponseHeaders(200, responseBytes.length);

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(responseBytes);
            }
        });

        server.start();

        System.out.println(
                "Server started at http://localhost:" + PORT
        );
    }
}
