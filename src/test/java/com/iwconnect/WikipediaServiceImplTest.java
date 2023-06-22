package com.iwconnect;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class WikipediaServiceImplTest {
    @Autowired
    private WikipediaService wikipediaService;

    @Test
    public void getByCountry_ValidCountryName_First2Entities() {
        var wikipediaEntities = wikipediaService.getByCountry("United States", 2);

        assertEquals(2, wikipediaEntities.size());
        assertTrue(
                wikipediaEntities.stream()
                        .allMatch(wikipedia -> wikipedia.getChannel().equals("#en.wikipedia"))
        );
    }

    @Test
    public void getByCityName_ValidCityName_ValidEntity() {
        var wikipediaEntity = wikipediaService.getByCityName("Auburn");

        assertEquals("#en.wikipedia", wikipediaEntity.get(0).getChannel());
    }

    @Test
    public void getLineSummariesByInterval_ValidIntervals_LineSummaries() {
        var startInterval = LocalDate.of(2015, 6, 27);
        var endInterval = LocalDate.of(2016, 6, 27);

        var lineSummaries = wikipediaService.getLineSummariesByInterval(startInterval, endInterval);

        assertEquals(24, lineSummaries.size());
    }

    @Test
    public void getAllByChannelLike_ValidChannel_AllEntities() {
        var wikipediaEntities = wikipediaService.getAllByChannel("#en.wikipedia");

        assertTrue(wikipediaEntities.stream().allMatch(wikipedia -> wikipedia.getChannel().equals("#en.wikipedia")));
    }
}
