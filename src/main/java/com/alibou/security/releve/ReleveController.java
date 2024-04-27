package com.alibou.security.releve;

import com.alibou.security.book.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/releve")
@RequiredArgsConstructor
public class ReleveController {
    private final ReleveService service;

    @PostMapping
    public ResponseEntity<?> saveReleve(@RequestBody ReleveRequest request) {
        Releve savedReleve = service.saveReleve(request);
        return ResponseEntity.accepted().body(savedReleve);
    }

    @PutMapping("/{releveId}")
    public ResponseEntity<?> updateReleve(
            @PathVariable Integer releveId,
            @RequestBody ReleveRequest request
    ) {
        Releve updatedReleve = service.updateReleve(releveId, request);
        return ResponseEntity.accepted().body(updatedReleve);
    }

    @DeleteMapping("/{releveId}")
    public ResponseEntity<?> deleteReleve(
            @PathVariable Integer releveId
    ) {
        service.deleteReleve(releveId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Releve>> findAllReleves() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<List<Releve>> findRelevesByUser(
            @PathVariable Integer idUser
    ){
        return ResponseEntity.ok(service.findByUser(idUser));
    }


}
