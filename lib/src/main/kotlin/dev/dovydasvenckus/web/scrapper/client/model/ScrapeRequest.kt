package dev.dovydasvenckus.web.scrapper.client.model

data class ScrapeRequest(
    val url: String,
    val steps: List<ScrapeStep>
)