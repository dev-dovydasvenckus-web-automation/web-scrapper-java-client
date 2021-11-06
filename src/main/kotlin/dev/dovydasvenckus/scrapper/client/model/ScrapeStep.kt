package dev.dovydasvenckus.scrapper.client.model

data class ScrapeStep(
    val type: StepType? = StepType.SCRAPE_TEXT,
    val fieldName: String,
    val attributeName: String? = null,
    val selector: String
)