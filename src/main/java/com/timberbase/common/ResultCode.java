package com.timberbase.common;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@Value
@Builder
@With
public class ResultCode {
    String code;

    String description;

    String detailedDescription;
}
