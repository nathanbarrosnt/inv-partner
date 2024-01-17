package com.neidev.invp.domain.core.cdb.response;

import com.neidev.invp.enums.InvestmentCategory;
import com.neidev.invp.enums.TitleCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class PostFixedCdbResponse {

    private String cdbName;
    private InvestmentCategory investmentCategory;
    private TitleCategory titleCategory;

    private BigDecimal applicationAmount;

    private BigDecimal grossValue;
    private BigDecimal incomeTax;

    private BigDecimal finalAmount;
    private BigDecimal worthValue;
}
