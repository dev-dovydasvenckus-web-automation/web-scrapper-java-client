package dev.dovydasvenckus.scrapper.client.model;

import java.util.List;

public class ScrapeResult {

    private final ScrapeStatus status;
    private final List<ScrapedField> data;

    public ScrapeResult(ScrapeStatus status, List<ScrapedField> data) {
        this.status = status;
        this.data = data;
    }

    public ScrapeStatus getStatus() {
        return status;
    }

    public List<ScrapedField> getData() {
        return data;
    }
}
