package com.avinty.hr.model.mapping;

import com.avinty.hr.model.dto.PositionDto;
import com.avinty.hr.model.persistence.position.Position;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DepartmentDtoPersistenceMapper.class})
public interface PositionDtoPersistenceMapper {

    PositionDto positionToDto(Position position);

    Position dtoToPosition(PositionDto dto);
}
