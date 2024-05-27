package com.alibou.security.facture;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FactureRepository extends JpaRepository<Facture, Integer> {
    List<Facture> findByEtat(String etat);
}
