package com.neidev.invp.domain.core.cdb.model;

import com.neidev.invp.enums.InvestmentCategory;
import com.neidev.invp.enums.TitleCategory;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostFixedCdb {

    private String cdbName;
    private BigDecimal cdiPercentage;
    private BigDecimal applicationAmount;

    private String expirationDate;

    private InvestmentCategory investmentCategory;
    private TitleCategory titleCategory;
}
