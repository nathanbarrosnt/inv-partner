package com.neidev.invp.domain.core.cdb.model;

import com.neidev.invp.enums.InvestmentCategory;
import com.neidev.invp.enums.TitleCategory;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PreFixedCdb {

    private String cdbName;
    private BigDecimal fixedPercentage;
    private BigDecimal applicationAmount;

    private LocalDateTime expirationDate;

    private InvestmentCategory investmentCategory;
    private TitleCategory titleCategory;
}
