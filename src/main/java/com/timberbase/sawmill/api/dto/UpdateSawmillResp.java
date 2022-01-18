package com.timberbase.sawmill.api.dto;

import com.timberbase.common.ResultCode;
import lombok.Builder;
import lombok.Value;
import lombok.With;

@Value
@Builder
@With
public class UpdateSawmillResp {
    ResultCode result;
}
