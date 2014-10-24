package com.experian.event;

public class RankingsReportEvent extends Event {
    private String website;
    private Region region;

    public RankingsReportEvent() {
        super(EventType.RANKINGS_REPORT);
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
