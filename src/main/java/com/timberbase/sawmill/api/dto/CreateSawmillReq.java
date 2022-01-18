package com.timberbase.sawmill.api.dto;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;

@Builder
@Value
public class CreateSawmillReq {
    @NotBlank(message = "city field must not be blank")
    String city;

    @NotBlank(message = "country field must not be blank")
    String country;

    @NotBlank(message = "name field must not be blank")
    String name;
}
