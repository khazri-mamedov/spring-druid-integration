package com.iwconnect.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity(name = "wikipedia")
public class Wikipedia {
    @Id
    @Column(name = "__time")
    private LocalDateTime time;

    private String channel;
    private String cityName;
}
