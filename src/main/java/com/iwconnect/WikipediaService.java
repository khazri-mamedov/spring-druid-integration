package com.iwconnect;

import com.iwconnect.dto.LineSummaryDto;
import com.iwconnect.dto.WikipediaDto;

import java.time.LocalDate;
import java.util.List;

public interface WikipediaService {
    List<LineSummaryDto> getLineSummariesByInterval(LocalDate startInterval, LocalDate endInterval);

    List<WikipediaDto> getByCountry(String countryName, Integer limit);

    List<WikipediaDto> getByCityName(String cityName);

    List<WikipediaDto> getAllByChannel(String channel);
}
