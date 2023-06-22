package com.iwconnect;

import com.iwconnect.dto.LineSummaryDto;
import com.iwconnect.dto.WikipediaDto;
import com.iwconnect.entity.Wikipedia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WikipediaServiceImpl implements WikipediaService {
    private final WikipediaRepository wikipediaRepository;
    private final WikipediaMapper wikipediaMapper;

    @Override
    public List<LineSummaryDto> getLineSummariesByInterval(LocalDate startInterval, LocalDate endInterval) {
        var lineSummaries = wikipediaRepository.findLineSummariesByHour(startInterval, endInterval);
        return wikipediaMapper.toLineSummariesDto(lineSummaries);
    }

    @Override
    public List<WikipediaDto> getByCountry(String countryName, Integer limit) {
        var wikipediaEntities = wikipediaRepository.findByCountryName(countryName, limit);
        return wikipediaMapper.toWikipediasDto(wikipediaEntities);
    }

    @Override
    public List<WikipediaDto> getByCityName(String cityName) {
        var wikipediaEntities = wikipediaRepository.findByCityName(cityName);
        return wikipediaMapper.toWikipediasDto(wikipediaEntities);
    }

    @Override
    public List<WikipediaDto> getAllByChannel(String channel) {
        var wikipediaEntities = wikipediaRepository.findAllByChannel(channel);
        return wikipediaMapper.toWikipediasDto(wikipediaEntities);
    }
}
