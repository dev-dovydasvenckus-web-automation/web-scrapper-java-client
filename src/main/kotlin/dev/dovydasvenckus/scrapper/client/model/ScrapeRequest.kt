package dev.dovydasvenckus.scrapper.client.model

data class ScrapeRequest(
    val url: String,
    val steps: List<ScrapeStep>
)