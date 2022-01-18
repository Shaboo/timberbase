package com.timberbase.sawmill.api.dto;

import lombok.Builder;
import lombok.Value;

import java.time.ZonedDateTime;

@Builder
@Value
public class SawmillDto {
    Long id;

    String city;

    String country;

    ZonedDateTime createdAt;

    String name;

    ZonedDateTime updatedAt;
}
