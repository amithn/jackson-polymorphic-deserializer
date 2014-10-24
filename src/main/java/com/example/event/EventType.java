package com.example.event;

/**
 * Created by voicestreams on 10/24/14.
 */
public enum EventType {
    DEMOGRAPHIC_REPORT("DEMOGRAPHIC_REPORT"),
    RANKINGS_REPORT("RANKINGS_REPORT");

    private final String type;

    EventType(String type) {
        this.type = type;
    }
}
