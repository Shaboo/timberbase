package com.timberbase.sawmill.api.dto;

import com.timberbase.common.ResultCode;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class GetSawmillResp {
    SawmillDto sawmill;

    ResultCode resultCode;
}
