package com.experian.event;

/**
 * Created by voicestreams on 10/24/14.
 */
public class DemographicReportEvent extends Event {
    private String expression;
    private Region region;

    public DemographicReportEvent() {
        super(EventType.DEMOGRAPHIC_REPORT);
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
