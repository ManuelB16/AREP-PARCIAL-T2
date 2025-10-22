package com.example.parcialarep.proxy;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Profile("proxy")
@RestController
public class ProxyController {

    private static final String MATH_SERVICE_1 = System.getenv("MATH_SERVICE_1") != null ? System.getenv("MATH_SERVICE_1") : "http://localhost:8081";
    private static final String MATH_SERVICE_2 = System.getenv("MATH_SERVICE_2") != null ? System.getenv("MATH_SERVICE_2") : "http://localhost:8082";

    @GetMapping("/lucasseq")
    public String proxyLucasSequence(@RequestParam int value) {
        String url1 = MATH_SERVICE_1 + "/lucasseq?value=" + value;
        String url2 = MATH_SERVICE_2 + "/lucasseq?value=" + value;

        try {
            return callService(url1);
        } catch (IOException e) {
            try {
                return callService(url2);
            } catch (IOException ex) {
                return "{\"error\": \"Both services are down\"}";
            }
        }
    }

    private String callService(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            throw new IOException("Service not available");
        }
    }
}
