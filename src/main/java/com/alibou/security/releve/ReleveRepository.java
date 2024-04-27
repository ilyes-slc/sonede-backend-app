package com.alibou.security.releve;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReleveRepository extends JpaRepository<Releve,Integer> {
        List<Releve> findByIdUser(Integer idUser);
    }
