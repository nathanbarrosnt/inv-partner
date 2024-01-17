package com.neidev.invp.domain.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CdbResponseForm {

    private String nome;
    private BigDecimal valorInvestido;

    private BigDecimal valorBruto;
    private BigDecimal impostoRenda;

    private BigDecimal valorLiquido;
    private BigDecimal rendimentoLiquido;
}
