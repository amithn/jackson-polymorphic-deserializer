package com.experian.event;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = DemographicReportEvent.class, name = "DEMOGRAPHIC_REPORT"),
                @JsonSubTypes.Type(value = RankingsReportEvent.class, name = "RANKINGS_REPORT") })
public abstract class Event {
    private EventType type;

    public Event() {
    }

    public Event(EventType type) {
        this.type = type;
    }

    public EventType getType() {
        return type;
    }
}
