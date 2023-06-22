package com.iwconnect.entity;

import java.time.LocalDateTime;

public interface LineSummary {
    LocalDateTime getTimeHour();

    Integer getLinesAdded();

    Integer getLinesDeleted();
}
