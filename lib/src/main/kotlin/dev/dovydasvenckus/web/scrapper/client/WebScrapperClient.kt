package dev.dovydasvenckus.web.scrapper.client

import dev.dovydasvenckus.web.scrapper.client.jackson.KotlinObjectMapperProvider
import dev.dovydasvenckus.web.scrapper.client.model.ScrapeRequest
import dev.dovydasvenckus.web.scrapper.client.model.ScrapeResult
import dev.dovydasvenckus.web.scrapper.client.service.ScrapingService
import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder

class WebScrapperClient(webScraperApiUrl: String) {
    private val scrapingService: ScrapingService = ScrapingService(webScraperApiUrl)
    private val client: Client = ClientBuilder.newBuilder()
        .register(KotlinObjectMapperProvider::class.java)
        .build()

    fun scrape(request: ScrapeRequest): ScrapeResult {
        return scrapingService.scrape(request, client)
    }
}