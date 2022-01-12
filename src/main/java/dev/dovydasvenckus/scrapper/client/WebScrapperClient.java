package dev.dovydasvenckus.scrapper.client;

import dev.dovydasvenckus.scrapper.client.model.ScrapeRequest;
import dev.dovydasvenckus.scrapper.client.model.ScrapeResult;
import dev.dovydasvenckus.scrapper.client.service.ScrapingService;

import java.net.http.HttpClient;

public class WebScrapperClient {
    private final ScrapingService scrapingService;
    private final HttpClient client = HttpClient.newBuilder().build();

    public WebScrapperClient(String webScraperApiUrl) {
        this.scrapingService = new ScrapingService(webScraperApiUrl);
    }

    public ScrapeResult scrape(ScrapeRequest request) {
        return scrapingService.scrape(request, client);
    }
}
