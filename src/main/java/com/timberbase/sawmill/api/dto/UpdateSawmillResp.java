package com.timberbase.sawmill.api.dto;

import com.timberbase.common.ResultCode;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UpdateSawmillResp {
    ResultCode result;
}
