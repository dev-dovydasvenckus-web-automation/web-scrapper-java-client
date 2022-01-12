package dev.dovydasvenckus.scrapper.client.service;

import com.google.gson.Gson;
import dev.dovydasvenckus.scrapper.client.model.ScrapeRequest;
import dev.dovydasvenckus.scrapper.client.model.ScrapeResult;
import dev.dovydasvenckus.scrapper.client.model.ScrapeStatus;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ScrapingService {

    private final String scraperApiUrl;
    private final Gson gson = new Gson();

    public ScrapingService(String scraperApiUrl) {
        this.scraperApiUrl = scraperApiUrl;
    }

    public ScrapeResult scrape(ScrapeRequest request, HttpClient client) {
        try {


            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(scraperApiUrl))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(request)))
                    .build();

            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if (HttpURLConnection.HTTP_OK == response.statusCode()) {
                return gson.fromJson(response.body(), ScrapeResult.class);
            }
            return new ScrapeResult(ScrapeStatus.FAILURE, null);
        } catch (Exception ex) {
            return new ScrapeResult(ScrapeStatus.FAILURE, null);
        }
    }
}
