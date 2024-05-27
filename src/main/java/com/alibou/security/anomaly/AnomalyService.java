package com.alibou.security.anomaly;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnomalyService {
    private final AnomalyRepository repository;

    public Anomaly saveAnomaly(AnomalyRequest request) {
        Anomaly anomaly = Anomaly.builder()
                .period(request.getPeriod())
                .index(request.getIndex())
                .idUser(request.getIdUser())
                .build();
        return repository.save(anomaly);
    }

    public Anomaly updateAnomaly(Integer anomalyId, AnomalyRequest request) {
        Anomaly anomaly = repository.findById(anomalyId).orElseThrow(() -> new RuntimeException("Anomaly not found"));
        anomaly.setPeriod(request.getPeriod());
        anomaly.setIndex(request.getIndex());
        anomaly.setIdUser(request.getIdUser());
        return repository.save(anomaly);
    }

    public void deleteAnomaly(Integer anomalyId) {
        repository.deleteById(anomalyId);
    }

    public List<Anomaly> findAll() {
        return repository.findAll();
    }

    public List<Anomaly> findByUser(Integer idUser) {
        return repository.findByIdUser(idUser);
    }
}
