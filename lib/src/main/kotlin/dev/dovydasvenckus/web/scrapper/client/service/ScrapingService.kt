package dev.dovydasvenckus.web.scrapper.client.service

import dev.dovydasvenckus.web.scrapper.client.model.ScrapeRequest
import dev.dovydasvenckus.web.scrapper.client.model.ScrapeResult
import javax.ws.rs.client.Client
import javax.ws.rs.client.Entity
import javax.ws.rs.core.MediaType

class ScrapingService(private val scraperApiUrl: String) {

    fun scrape(request: ScrapeRequest, client: Client): ScrapeResult {
        val response = client
            .target(scraperApiUrl)
            .request(MediaType.APPLICATION_JSON)
            .post(Entity.entity(request, MediaType.APPLICATION_JSON))

        return response.readEntity(ScrapeResult::class.java)
    }
}