package dev.dovydasvenckus.web.scrapper.client.model

data class ScrapeResult(
    val status: ScrapeStatus,
    val data: List<ScrapedField>
)