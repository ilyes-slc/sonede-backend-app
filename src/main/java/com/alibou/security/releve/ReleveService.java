package com.alibou.security.releve;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ReleveService {
    private final ReleveRepository releveRepository;

    public Releve saveReleve(ReleveRequest releveRequest) {
        int consommation = releveRequest.getNouveauIndex() - releveRequest.getAncienIndex();
        Releve releve = Releve.builder()
                .periode(releveRequest.getPeriode())
                .ancienIndex(releveRequest.getAncienIndex())
                .nouveauIndex(releveRequest.getNouveauIndex())
                .consommation(consommation)
                .idUser(releveRequest.getIdUser())
                .build();

        return releveRepository.save(releve);
    }

    public Releve updateReleve(Integer releveId, ReleveRequest releveRequest) {
        Releve releveToUpdate = releveRepository.findById(releveId)
                .orElseThrow(() -> new NoSuchElementException("Releve with id " + releveId + " not found"));

        int consommation = releveRequest.getNouveauIndex() - releveRequest.getAncienIndex();

        releveToUpdate.setPeriode(releveRequest.getPeriode());
        releveToUpdate.setAncienIndex(releveRequest.getAncienIndex());
        releveToUpdate.setNouveauIndex(releveRequest.getNouveauIndex());
        releveToUpdate.setConsommation(consommation);
        releveToUpdate.setIdUser(releveRequest.getIdUser());

        return releveRepository.save(releveToUpdate);
    }

    public void deleteReleve(Integer releveId) {
        releveRepository.deleteById(releveId);
    }

    public List<Releve> findAll(){
        return releveRepository.findAll();
    }
    public List<Releve> findByUser(Integer idUser){
        return releveRepository.findByIdUser(idUser);
    }


}
