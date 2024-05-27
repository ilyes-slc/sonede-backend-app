package com.alibou.security.paiement;

import lombok.Data;

@Data
public class PaiementRequest {
    private String date;
    private Integer factureId;
    private Double montant;
    private Boolean effectue;
}
