package com.alibou.security.facture;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/factures")
@RequiredArgsConstructor
public class FactureController {
    private final FactureService service;

    @PostMapping
    public ResponseEntity<Facture> saveFacture(@RequestBody FactureRequest request) {
        Facture savedFacture = service.saveFacture(request);
        return ResponseEntity.accepted().body(savedFacture);
    }

    @PutMapping("/{factureId}")
    public ResponseEntity<Facture> updateFacture(
            @PathVariable Integer factureId,
            @RequestBody FactureRequest request
    ) {
        Facture updatedFacture = service.updateFacture(factureId, request);
        return ResponseEntity.accepted().body(updatedFacture);
    }

    @DeleteMapping("/{factureId}")
    public ResponseEntity<Void> deleteFacture(
            @PathVariable Integer factureId
    ) {
        service.deleteFacture(factureId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Facture>> findAllFactures() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/etat/{etat}")
    public ResponseEntity<List<Facture>> findFacturesByEtat(
            @PathVariable String etat
    ){
        return ResponseEntity.ok(service.findByEtat(etat));
    }
}
