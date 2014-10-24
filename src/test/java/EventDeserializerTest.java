import com.example.event.DemographicReportEvent;
import com.example.event.Event;
import com.example.event.EventType;
import com.example.event.RankingsReportEvent;
import com.example.event.Region;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class EventDeserializerTest {

    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

   @Test
   public void testDemographicReportEventDeserialization() throws IOException {
       File jsonFile = getFile("serialize/demographic_report_event.json");
       Event event = objectMapper.readValue(jsonFile, Event.class);

       assertThat(event.getType(), is(EventType.DEMOGRAPHIC_REPORT));
       assertTrue(event instanceof DemographicReportEvent);

       DemographicReportEvent demographicReportEvent  = (DemographicReportEvent) event;
       assertThat(demographicReportEvent.getExpression(), is("HWVISITS('www.google.com')"));
       assertThat(demographicReportEvent.getRegion(), is(Region.UK));
   }

    @Test
    public void testRankingsReportEventDeserialization() throws IOException {
        File jsonFile = getFile("serialize/rankings_report_event.json");

        Event event = objectMapper.readValue(jsonFile, Event.class);
        assertThat(event.getType(), is(EventType.RANKINGS_REPORT));
        assertTrue(event instanceof RankingsReportEvent);

        RankingsReportEvent rankingsReportEvent  = (RankingsReportEvent) event;
        assertThat(rankingsReportEvent.getWebsite(), is("www.google.com"));
        assertThat(rankingsReportEvent.getRegion(), is(Region.AU));
    }

    private File getFile(String fileName) {
        URL url = this.getClass().getResource(fileName);
        return new File(url.getFile());
    }
}
