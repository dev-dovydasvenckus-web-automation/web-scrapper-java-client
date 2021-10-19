package dev.dovydasvenckus.scrapper.client

import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder
import dev.dovydasvenckus.scrapper.client.jackson.KotlinObjectMapperProvider
import dev.dovydasvenckus.scrapper.client.model.ScrapeRequest
import dev.dovydasvenckus.scrapper.client.model.ScrapeResult
import dev.dovydasvenckus.scrapper.client.service.ScrapingService

class WebScrapperClient(webScraperApiUrl: String) {
    private val scrapingService: ScrapingService = ScrapingService(webScraperApiUrl)
    private val client: Client = ClientBuilder.newBuilder()
        .register(KotlinObjectMapperProvider::class.java)
        .build()

    fun scrape(request: ScrapeRequest): ScrapeResult {
        return scrapingService.scrape(request, client)
    }
}