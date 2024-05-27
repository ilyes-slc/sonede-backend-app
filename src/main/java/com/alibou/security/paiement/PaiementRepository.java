package com.alibou.security.paiement;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaiementRepository extends JpaRepository<Paiement, Integer> {
    List<Paiement> findByEffectue(Boolean effectue);
}
