package no.kristiania.http;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpClientTest {
    @Test
    void mathShouldWork() {
        assertEquals(5, 2+3);
    }

    @Test
    void shouldReadStatusCode200() throws IOException {
        HttpClient client = new HttpClient("urlecho.appspot.com", "/echo");
        HttpClientResponse response = client.executeRequest();
        assertEquals(200, response.getStatusCode());
    }

    @Test
    void shouldReadStatusCode401() throws IOException {
        HttpClient client = new HttpClient("urlecho.appspot.com", "/echo?status=401");
        HttpClientResponse response = client.executeRequest();
        assertEquals(401, response.getStatusCode());
    }
}
