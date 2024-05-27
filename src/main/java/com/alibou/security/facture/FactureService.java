package com.alibou.security.facture;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FactureService {
    private final FactureRepository repository;

    public Facture saveFacture(FactureRequest request) {
        Facture facture = Facture.builder()
                .period(request.getPeriod())
                .montant(request.getMontant())
                .etat(request.getEtat())
                .build();
        return repository.save(facture);
    }

    public Facture updateFacture(Integer factureId, FactureRequest request) {
        Facture facture = repository.findById(factureId).orElseThrow(() -> new RuntimeException("Facture not found"));
        facture.setPeriod(request.getPeriod());
        facture.setMontant(request.getMontant());
        facture.setEtat(request.getEtat());
        return repository.save(facture);
    }

    public void deleteFacture(Integer factureId) {
        repository.deleteById(factureId);
    }

    public List<Facture> findAll() {
        return repository.findAll();
    }

    public List<Facture> findByEtat(String etat) {
        return repository.findByEtat(etat);
    }
}
