package com.avinty.hr.model.persistence.position;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, String> {

    Position findByPositionId(String positionId);
}
