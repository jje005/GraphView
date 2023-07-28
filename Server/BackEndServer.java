package Server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BackEndServer {
    private final String HOSTNAME = "localhost";
    private final int PORT = 8080;
    private final int BACKLOG = 0;
    private HttpServer server = null;

    public BackEndServer() throws IOException {
        this.server = HttpServer.create(new InetSocketAddress(HOSTNAME, PORT), BACKLOG);
        server.createContext("/", new RootHandler());
    }

    // 서버 실행 메서드
    public void start() {
        server.start();
    }

    // 서버 중지 메서드
    public void stop(int delay) {
        server.stop(delay);
    }

    // 루트 핸들러
    static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "<h1>Make Server</h1>";
            response += "<h2>Go to Home</h2>";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    public static void main(String[] args) throws IOException {
        BackEndServer server = new BackEndServer();

        try {
            System.out.printf(
                    "[%s][HTTP SERVER][START]%n",
                    new SimpleDateFormat("yyy-MM-dd H:mm:ss").format(new Date())
            );
            server.start();


            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                @Override
                public void run() {
                    // 종료 로그
                    System.out.printf(
                            "[%s][HTTP SERVER][STOP]%n",
                            new SimpleDateFormat("yyy-MM-dd H:mm:ss").format(new Date())
                    );
                }
            }));
            System.out.println("Please press 'Enter' to stop the server");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            server.stop(1000);
        }
    }
}