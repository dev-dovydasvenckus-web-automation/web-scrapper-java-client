package dev.dovydasvenckus.scrapper.client.model;

import java.util.Optional;

public class ScrapeStep {

    private final StepType stepType;
    private final String fieldName;
    private final String attributeName;
    private final String selector;

    public ScrapeStep(StepType stepType, String fieldName, String attributeName, String selector) {
        this.stepType = Optional.ofNullable(stepType).orElse(StepType.SCRAPE_TEXT);
        this.fieldName = fieldName;
        this.attributeName = attributeName;
        this.selector = selector;
    }

    public StepType getStepType() {
        return stepType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public String getSelector() {
        return selector;
    }
}
