package dev.dovydasvenckus.scrapper.client;

import dev.dovydasvenckus.scrapper.client.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.junit.jupiter.MockServerExtension;
import org.mockserver.junit.jupiter.MockServerSettings;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.model.JsonBody;
import org.mockserver.model.MediaType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@ExtendWith(MockServerExtension.class)
@MockServerSettings(ports = {8787, 8888})
public class WebScrapperClientTest {

    private final ClientAndServer client;

    public WebScrapperClientTest(ClientAndServer client) {
        this.client = client;
    }

    @Test
    public void whenClientIsInvoked_itShouldPostRequestAndMapResultToResponseObject() {
        String httpServerApiUrl = mockServer();
        WebScrapperClient testTarget = new WebScrapperClient(httpServerApiUrl);
        ScrapeRequest scrapeRequest = new ScrapeRequest("https://site-to.scrape/", List.of(createScrapeStep()));

        ScrapeResult result = testTarget.scrape(scrapeRequest);

        assertThat(result.getStatus()).isEqualTo(ScrapeStatus.SUCCESS);
        assertThat(result.getData()).containsOnly(new ScrapedField("cases", "200"));
    }

    private ScrapeStep createScrapeStep() {
        return new ScrapeStep(StepType.SCRAPE_TEXT, "cases", null, ".some-selector");
    }

    private String mockServer() {
        HttpRequest request = request()
                .withMethod("POST")
                .withPath("/scrape")
                .withContentType(MediaType.APPLICATION_JSON)
                .withBody(JsonBody.json("{\"url\": \"https://site-to.scrape/\", \"steps\": [{\"stepType\": \"SCRAPE_TEXT\", \"fieldName\": \"cases\", \"selector\": \".some-selector\"}]}"));

        HttpResponse response = response()
                .withStatusCode(200)
                .withContentType(MediaType.APPLICATION_JSON)
                .withBody("{\"status\": \"SUCCESS\", \"data\": [{\"name\": \"cases\", \"value\": \"200\"}]}");

        client.when(request).respond(response);
        return String.format("http://localhost:%s/scrape", client.getLocalPort());
    }
}
