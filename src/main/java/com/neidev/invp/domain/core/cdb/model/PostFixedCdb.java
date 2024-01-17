package com.neidev.invp.domain.core.cdb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.neidev.invp.enums.InvestmentCategory;
import com.neidev.invp.enums.TitleCategory;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostFixedCdb {

    private String cdbName;
    private BigDecimal cdiPercentage;
    private BigDecimal applicationAmount;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate expirationDate;

    private InvestmentCategory investmentCategory;
    private TitleCategory titleCategory;
}
