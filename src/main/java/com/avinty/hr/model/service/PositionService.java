package com.avinty.hr.model.service;

import com.avinty.hr.model.dto.PositionDto;

public interface PositionService {

    void savePosition(PositionDto positionDto);
    void deletePosition(PositionDto positionDto);
    PositionDto findPositionById(String positionId);
}
