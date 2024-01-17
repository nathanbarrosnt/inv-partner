package com.neidev.invp.domain.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CdbForm {

    private String nome;
    private BigDecimal porcentagemCdi;
    private BigDecimal valorAplicacao;
}
