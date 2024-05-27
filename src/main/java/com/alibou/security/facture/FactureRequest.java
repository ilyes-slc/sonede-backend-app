package com.alibou.security.facture;

import lombok.Data;

@Data
public class FactureRequest {
    private String period;
    private Double montant;
    private String etat;
}
