package com.alibou.security.anomaly;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnomalyRepository extends JpaRepository<Anomaly, Integer> {
    List<Anomaly> findByIdUser(Integer idUser);
}