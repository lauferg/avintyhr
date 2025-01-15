package com.avinty.hr.model.service.implementation;

import com.avinty.hr.model.dto.PositionDto;
import com.avinty.hr.model.mapping.PositionDtoPersistenceMapper;
import com.avinty.hr.model.persistence.position.Position;
import com.avinty.hr.model.persistence.position.PositionRepository;
import com.avinty.hr.model.service.PositionService;
import org.springframework.stereotype.Service;

@Service
public class JpaRepoBasedPositionService implements PositionService {

    private final PositionRepository positionRepository;

    private final PositionDtoPersistenceMapper persistenceMapper;

    public JpaRepoBasedPositionService(PositionRepository positionRepository, PositionDtoPersistenceMapper persistenceMapper) {
        this.positionRepository = positionRepository;
        this.persistenceMapper = persistenceMapper;
    }

    @Override
    public void savePosition(PositionDto positionDto) {
        Position position = persistenceMapper.dtoToPosition(positionDto);
        positionRepository.save(position);
    }

    @Override
    public void deletePosition(PositionDto positionDto) {
        Position position = persistenceMapper.dtoToPosition(positionDto);
        positionRepository.delete(position);
    }

    @Override
    public PositionDto findPositionById(String positionId) {
        Position position = positionRepository.findByPositionId(positionId);
        return persistenceMapper.positionToDto(position);
    }
}
