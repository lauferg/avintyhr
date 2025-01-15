package com.avinty.hr.controller;

import com.avinty.hr.model.dto.PositionDto;
import com.avinty.hr.model.service.PositionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/API/V1/position")
public class PositionController {

    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @PostMapping("/save")
    public ResponseEntity<Integer> save(@RequestBody PositionDto positionDto) {
        positionService.savePosition(positionDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Integer> delete(@RequestBody PositionDto positionDto) {
        positionService.deletePosition(positionDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/id")
    public ResponseEntity<PositionDto> findById(@RequestParam String positionId) {
        return ResponseEntity.ok(positionService.findPositionById(positionId));
    }
}
