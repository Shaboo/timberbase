package com.timberbase.sawmill.api.controller;

import com.timberbase.common.ResultCode;
import com.timberbase.sawmill.api.dto.CreateSawmillReq;
import com.timberbase.sawmill.api.dto.CreateSawmillResp;
import com.timberbase.sawmill.api.dto.GetSawmillResp;
import com.timberbase.sawmill.api.dto.SawmillDto;
import com.timberbase.sawmill.api.dto.SawmillResultCodes;
import com.timberbase.sawmill.api.dto.UpdateSawmillReq;
import com.timberbase.sawmill.api.dto.UpdateSawmillResp;
import com.timberbase.sawmill.service.SawmillService;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SawmillController {
    private final SawmillService sawmillService;

    public SawmillController(SawmillService sawmillService) {
        this.sawmillService = sawmillService;
    }

    @PostMapping("/sawmill")
    public ResponseEntity<CreateSawmillResp> createSawmill(@RequestBody @Validated CreateSawmillReq createSawmillReq,
                                                           BindingResult result) {
        if (result.hasErrors()) {
            FieldError fieldError = result.getFieldErrors().get(0);
            return ResponseEntity.badRequest().body(CreateSawmillResp.builder()
                    .result(SawmillResultCodes.INVALID_SAWMILL.withDetailedDescription(
                            fieldError.getDefaultMessage())).build());
        }

        sawmillService.createSawmill(createSawmillReq);

        return ResponseEntity.ok(CreateSawmillResp.builder()
                .result(SawmillResultCodes.SAWMILL_CREATED)
                .build());
    }

    @GetMapping("/sawmill/{id}")
    public ResponseEntity<GetSawmillResp> getSawmillByName(@PathVariable Long id) {
        Either<ResultCode, GetSawmillResp> errorOrSawmillResp = sawmillService.findSawmillById(id);

        if (errorOrSawmillResp.isLeft()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(GetSawmillResp.builder()
                            .resultCode(errorOrSawmillResp.getLeft())
                    .build());
        }

        return ResponseEntity.ok(errorOrSawmillResp.get());
    }

    @PutMapping("/sawmill/{id}")
    public ResponseEntity<UpdateSawmillResp> updateSawmill(@PathVariable Long id,
                                                           @RequestBody @Validated UpdateSawmillReq updateSawmillReq) {
        UpdateSawmillResp resp;
        Either<ResultCode, Void> errorOrUpdated = sawmillService.updateSawmill(id, updateSawmillReq);

        if (errorOrUpdated.isLeft()) {
            ResultCode resultCode = errorOrUpdated.getLeft();
            resp = UpdateSawmillResp.builder()
                    .result(resultCode)
                    .build();

            if (resultCode.getCode().equalsIgnoreCase(SawmillResultCodes.SAWMILL_NOT_FOUND_CODE)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
            }

            return ResponseEntity.badRequest().body(resp);
        }

        resp = UpdateSawmillResp.builder()
                .result(SawmillResultCodes.SAWMILL_DETAILS_UPDATED)
                .build();

        return ResponseEntity.ok(resp);
    }

    @GetMapping("/sawmill")
    public ResponseEntity<List<SawmillDto>> getAllSawmillsAndFilterByName(@RequestParam(value = "name", required = false)  String name) {
        return ResponseEntity.ok(sawmillService.findAllByName(name));
    }
}
