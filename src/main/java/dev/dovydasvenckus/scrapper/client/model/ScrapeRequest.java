package dev.dovydasvenckus.scrapper.client.model;

import java.util.List;

public class ScrapeRequest {

    private final String url;
    private final List<ScrapeStep> steps;

    public ScrapeRequest(String url, List<ScrapeStep> steps) {
        this.url = url;
        this.steps = steps;
    }

    public String getUrl() {
        return url;
    }

    public List<ScrapeStep> getSteps() {
        return steps;
    }
}
