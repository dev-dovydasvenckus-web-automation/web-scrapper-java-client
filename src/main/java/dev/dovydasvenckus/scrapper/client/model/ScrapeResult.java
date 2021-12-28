package dev.dovydasvenckus.scrapper.client.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ScrapeResult {

    private final ScrapeStatus status;
    private final List<ScrapedField> data;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ScrapeResult(@JsonProperty("status") ScrapeStatus status, @JsonProperty("data") List<ScrapedField> data) {
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
