package com.timberbase.sawmill.service;

import com.timberbase.common.ResultCode;
import com.timberbase.sawmill.api.dto.CreateSawmillReq;
import com.timberbase.sawmill.api.dto.GetSawmillResp;
import com.timberbase.sawmill.api.dto.SawmillDto;
import com.timberbase.sawmill.api.dto.SawmillResultCodes;
import com.timberbase.sawmill.api.dto.UpdateSawmillReq;
import com.timberbase.sawmill.model.SawmillModel;
import com.timberbase.sawmill.repository.SawmillRepository;
import io.vavr.control.Either;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SawmillService {
    private final SawmillRepository sawmillRepository;

    public SawmillService(SawmillRepository sawmillRepository) {
        this.sawmillRepository = sawmillRepository;
    }

    public void createSawmill(CreateSawmillReq createSawmillReq) {
        SawmillModel sawmillModel = SawmillModel.builder()
                .name(createSawmillReq.getName())
                .city(createSawmillReq.getCity())
                .country(createSawmillReq.getCountry())
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();

        sawmillRepository.saveAndFlush(sawmillModel);
    }

    public Either<ResultCode, GetSawmillResp> findSawmillById(Long id) {
        Optional<SawmillModel> sawmillModel = sawmillRepository.findById(id);
        if (!sawmillModel.isPresent()) {
            return Either.left(SawmillResultCodes.SAWMILL_NOT_FOUND);
        }

        SawmillModel model = sawmillModel.get();
        return Either.right(GetSawmillResp.builder()
                .sawmill(SawmillDto.builder()
                        .id(model.getId())
                        .city(model.getCity())
                        .name(model.getName())
                        .country(model.getCountry())
                        .createdAt(model.getCreatedAt())
                        .updatedAt(model.getUpdatedAt())
                        .build())
                    .resultCode(SawmillResultCodes.SAWMILL_DETAILS_RETRIEVED)
                    .build());
    }

    public Either<ResultCode, Void> updateSawmill(Long id, UpdateSawmillReq updateSawmillReq) {
        Optional<SawmillModel> sawmillModel = sawmillRepository.findById(id);
        if (!sawmillModel.isPresent()) {
            return Either.left(SawmillResultCodes.SAWMILL_NOT_FOUND);
        }

        SawmillModel model = sawmillModel.get();
        model.setCity(updateSawmillReq.getCity());
        model.setCountry(updateSawmillReq.getCountry());
        model.setName(updateSawmillReq.getName());
        model.setUpdatedAt(ZonedDateTime.now());

        sawmillRepository.saveAndFlush(model);
        return Either.right(null);
    }

    public List<SawmillDto> findAllByName(String name) {
        if (ObjectUtils.isEmpty(name)) {
            return sawmillRepository.findAll().stream()
                    .map(this::toSawmillDto)
                    .collect(Collectors.toList());
        }

        return sawmillRepository.findAllByName(name).stream()
                 .map(this::toSawmillDto)
                 .collect(Collectors.toList());
    }

    private SawmillDto toSawmillDto(SawmillModel model) {
        return SawmillDto.builder()
                .id(model.getId())
                .city(model.getCity())
                .country(model.getCountry())
                .name(model.getName())
                .createdAt(model.getCreatedAt())
                .updatedAt(model.getUpdatedAt())
                .build();
    }
}
