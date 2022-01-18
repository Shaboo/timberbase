package com.timberbase.sawmill.api.dto;

import com.timberbase.common.ResultCode;

public class SawmillResultCodes {
    public static final String SAWMILL_CREATED_CODE = "sawmill/sawmill_created";
    public static final String SAWMILL_CREATED_DESCRIPTION = "sawmill created";
    public static final String INVALID_SAWMILL_CODE = "sawmill/invalid_sawmill";
    public static final String INVALID_SAWMILL_DESCRIPTION = "Provided sawmill is invalid.";
    public static final String SAWMILL_NOT_FOUND_CODE = "sawmill/sawmill_not_found";
    public static final String SAWMILL_NOT_FOUND_DESCRIPTION = "Sawmill not found.";
    public static final String SAWMILL_DETAILS_RETRIEVED_CODE = "sawmill/sawmill_details_retrieved";
    public static final String SAWMILL_DETAILS_RETRIEVED_DESCRIPTION = "Sawmill details retrieved.";
    public static final String SAWMILL_DETAILS_UPDATED_CODE = "sawmill/sawmill_details_updated";
    public static final String SAWMILL_DETAILS_UPDATED_DESCRIPTION = "Sawmill details updated successfully.";

    public static final ResultCode SAWMILL_CREATED = ResultCode.builder()
            .code(SAWMILL_CREATED_CODE)
            .description(SAWMILL_CREATED_DESCRIPTION)
            .build();

    public static final ResultCode INVALID_SAWMILL = ResultCode.builder()
            .code(INVALID_SAWMILL_CODE)
            .description(INVALID_SAWMILL_DESCRIPTION)
            .build();

    public static final ResultCode SAWMILL_NOT_FOUND = ResultCode.builder()
            .code(SAWMILL_NOT_FOUND_CODE)
            .description(SAWMILL_NOT_FOUND_DESCRIPTION)
            .build();

    public static final ResultCode SAWMILL_DETAILS_RETRIEVED = ResultCode.builder()
            .code(SAWMILL_DETAILS_RETRIEVED_CODE)
            .description(SAWMILL_DETAILS_RETRIEVED_DESCRIPTION)
            .build();

    public static final ResultCode SAWMILL_DETAILS_UPDATED = ResultCode.builder()
            .code(SAWMILL_DETAILS_UPDATED_CODE)
            .description(SAWMILL_DETAILS_UPDATED_DESCRIPTION)
            .build();
}
