package com.alibou.security.anomaly;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/anomalies")
@RequiredArgsConstructor
public class AnomalyController {
    private final AnomalyService service;

    @PostMapping
    public ResponseEntity<Anomaly> saveAnomaly(@RequestBody AnomalyRequest request) {
        Anomaly savedAnomaly = service.saveAnomaly(request);
        return ResponseEntity.accepted().body(savedAnomaly);
    }

    @PutMapping("/{anomalyId}")
    public ResponseEntity<Anomaly> updateAnomaly(
            @PathVariable Integer anomalyId,
            @RequestBody AnomalyRequest request
    ) {
        Anomaly updatedAnomaly = service.updateAnomaly(anomalyId, request);
        return ResponseEntity.accepted().body(updatedAnomaly);
    }

    @DeleteMapping("/{anomalyId}")
    public ResponseEntity<Void> deleteAnomaly(
            @PathVariable Integer anomalyId
    ) {
        service.deleteAnomaly(anomalyId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Anomaly>> findAllAnomalies() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/user/{idUser}")
    public ResponseEntity<List<Anomaly>> findAnomaliesByUser(
            @PathVariable Integer idUser
    ){
        return ResponseEntity.ok(service.findByUser(idUser));
    }
}
