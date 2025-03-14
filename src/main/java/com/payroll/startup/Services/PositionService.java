package com.payroll.startup.Services;

import com.payroll.startup.Models.Position;
import com.payroll.startup.Models.Employee;
import com.payroll.startup.Models.Job;
import com.payroll.startup.Repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {
    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    public Position getPositionById(Integer id) {
        return positionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Position with ID " + id + " not found"));
    }

    public void addPosition(Position position) {
        positionRepository.save(position);
    }

    public void deletePosition(Integer id) {
        if (!positionRepository.existsById(id)) {
            throw new IllegalArgumentException("Position with ID " + id + " not found");
        }
        positionRepository.deleteById(id);
    }

    public void updatePosition(Integer id, String positionCode, String status, Employee employee) {
        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Position with ID " + id + " not found"));

        if (positionCode != null && !positionCode.isEmpty()) position.setPositionCode(positionCode);
        if (status != null && !status.isEmpty()) position.setStatus(status);
        if (employee != null) position.setEmployee(employee);

        positionRepository.save(position);
    }

}
