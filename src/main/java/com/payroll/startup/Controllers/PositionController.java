package com.payroll.startup.Controllers;

import com.payroll.startup.Models.Employee;
import com.payroll.startup.Models.Position;
import com.payroll.startup.Services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/positions/")
public class PositionController {

    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("all")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping("{position_id}")
    public Position getPositionById(@PathVariable("position_id") Integer id) {
        return positionService.getPositionById(id);

    }

    @PostMapping
    public void addPosition(@RequestBody Position position) {
        positionService.addPosition(position);
    }

    @PutMapping("{position_id}")
    public void updatePosition(
            @PathVariable("position_id") Integer id,
            @RequestParam(required = false) String positionCode,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Employee employee
            ) {
        positionService.updatePosition(id, positionCode, status, employee);
    }

    @DeleteMapping("{position_id}")
    public void deletePosition(@PathVariable("position_id") Integer id) {
        positionService.deletePosition(id);
    }
}
