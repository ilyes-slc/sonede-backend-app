package com.alibou.security.anomaly;

import lombok.Data;

@Data
public class AnomalyRequest {
    private String period;
    private String index;
    private Integer idUser;
}
