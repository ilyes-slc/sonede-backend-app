package com.alibou.security.paiement;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/paiements")
@RequiredArgsConstructor
public class PaiementController {
    private final PaiementService service;

    @PostMapping
    public ResponseEntity<Paiement> savePaiement(@RequestBody PaiementRequest request) {
        Paiement savedPaiement = service.savePaiement(request);
        return ResponseEntity.accepted().body(savedPaiement);
    }

    @PutMapping("/{paiementId}")
    public ResponseEntity<Paiement> updatePaiement(
            @PathVariable Integer paiementId,
            @RequestBody PaiementRequest request
    ) {
        Paiement updatedPaiement = service.updatePaiement(paiementId, request);
        return ResponseEntity.accepted().body(updatedPaiement);
    }

    @DeleteMapping("/{paiementId}")
    public ResponseEntity<Void> deletePaiement(
            @PathVariable Integer paiementId
    ) {
        service.deletePaiement(paiementId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Paiement>> findAllPaiements() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/effectue/{effectue}")
    public ResponseEntity<List<Paiement>> findPaiementsByEffectue(
            @PathVariable Boolean effectue
    ){
        return ResponseEntity.ok(service.findByEffectue(effectue));
    }
}
