package com.iwconnect;

import com.iwconnect.dto.LineSummaryDto;
import com.iwconnect.dto.WikipediaDto;
import com.iwconnect.entity.LineSummary;
import com.iwconnect.entity.Wikipedia;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface WikipediaMapper {
    List<LineSummaryDto> toLineSummariesDto(List<LineSummary> lineSummaries);

    List<WikipediaDto> toWikipediasDto(List<Wikipedia> wikipediaEntities);
}
