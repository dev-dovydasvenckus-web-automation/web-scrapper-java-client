package dev.dovydasvenckus.scrapper.client.service;

import dev.dovydasvenckus.scrapper.client.model.ScrapeRequest;
import dev.dovydasvenckus.scrapper.client.model.ScrapeResult;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class ScrapingService {

    private final String scraperApiUrl;

    public ScrapingService(String scraperApiUrl) {
        this.scraperApiUrl = scraperApiUrl;
    }

    public ScrapeResult scrape(ScrapeRequest request, Client client) {
        Response response = client
                .target(scraperApiUrl)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(request, MediaType.APPLICATION_JSON));

        return response.readEntity(ScrapeResult.class);
    }
}
