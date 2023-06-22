package com.iwconnect.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LineSummaryDto {
    private LocalDateTime timeHour;
    private Integer linesAdded;
    private Integer linesDeleted;
}
