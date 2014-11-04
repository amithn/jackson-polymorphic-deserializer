package com.example.event;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = DemographicReportEvent.class, name = "DEMOGRAPHIC_REPORT"),
                @JsonSubTypes.Type(value = RankingsReportEvent.class, name = "RANKINGS_REPORT") })
public abstract class Event {

    /* The required rule is not enforced by default */
    @JsonProperty(value = "id", required = true)
    private String id;

    private EventType type;

    public Event() {
    }

    public Event(EventType type) {
        this.type = type;
    }

    public EventType getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
