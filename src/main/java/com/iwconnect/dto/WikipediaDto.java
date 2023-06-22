package com.iwconnect.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WikipediaDto {
    private LocalDateTime time;
    private String channel;
    private String cityName;
}
