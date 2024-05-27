package com.alibou.security.paiement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaiementService {
    private final PaiementRepository repository;

    public Paiement savePaiement(PaiementRequest request) {
        Paiement paiement = Paiement.builder()
                .date(request.getDate())
                .factureId(request.getFactureId())
                .montant(request.getMontant())
                .effectue(request.getEffectue())
                .build();
        return repository.save(paiement);
    }

    public Paiement updatePaiement(Integer paiementId, PaiementRequest request) {
        Paiement paiement = repository.findById(paiementId).orElseThrow(() -> new RuntimeException("Paiement not found"));
        paiement.setDate(request.getDate());
        paiement.setFactureId(request.getFactureId());
        paiement.setMontant(request.getMontant());
        paiement.setEffectue(request.getEffectue());
        return repository.save(paiement);
    }

    public void deletePaiement(Integer paiementId) {
        repository.deleteById(paiementId);
    }

    public List<Paiement> findAll() {
        return repository.findAll();
    }

    public List<Paiement> findByEffectue(Boolean effectue) {
        return repository.findByEffectue(effectue);
    }
}
