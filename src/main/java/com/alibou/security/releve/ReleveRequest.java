package com.alibou.security.releve;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class ReleveRequest {
    private Date periode;
    private Integer ancienIndex;
    private Integer index;
    private Integer idUser;
}
