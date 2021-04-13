import com.example.springboot.client.YourCustomCollector;
import com.example.springboot.client.YourCustomCollector2;
import io.prometheus.client.exporter.HTTPServer;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        new YourCustomCollector().register();
        new YourCustomCollector2().register();
        HTTPServer server = new HTTPServer(1234);
    }
}
