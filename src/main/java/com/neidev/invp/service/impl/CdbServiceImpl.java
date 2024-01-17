package com.neidev.invp.service.impl;

import com.neidev.invp.domain.core.cdb.model.PostFixedCdb;
import com.neidev.invp.domain.core.cdb.model.PreFixedCdb;
import com.neidev.invp.domain.core.cdb.response.PostFixedCdbResponse;
import com.neidev.invp.service.CdbServiceUseCase;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class CdbServiceImpl implements CdbServiceUseCase {

    @Override
    public PostFixedCdbResponse calculate(PostFixedCdb data) {
        var actualDate = LocalDate.now();
        var differenceInYears =
                (int) actualDate.until(data.getExpirationDate(), ChronoUnit.YEARS);

        // calculating taxes
        var cdiPercentage = data.getCdiPercentage()
                .divide(BigDecimal.valueOf(100))
                .setScale(2, RoundingMode.HALF_DOWN);

        var tax = cdiPercentage
                .multiply(BigDecimal.valueOf(11.65))
                .divide(BigDecimal.valueOf(100))
                .setScale(2, RoundingMode.HALF_EVEN);

        var index = new BigDecimal(1).add(tax)
                .setScale(2, RoundingMode.HALF_DOWN);
        // calculating values
        var grossValue = data.getApplicationAmount()
                .multiply(index)
                .pow(differenceInYears)
                .setScale(2, RoundingMode.HALF_EVEN);

        var incomeTax = grossValue
                .subtract(data.getApplicationAmount())
                .multiply(BigDecimal.valueOf(0.20))
                .setScale(2, RoundingMode.HALF_EVEN);

        var finalAmount = grossValue
                .subtract(incomeTax)
                .setScale(2, RoundingMode.HALF_EVEN);

        var worthValue = finalAmount
                .subtract(data.getApplicationAmount())
                .setScale(2, RoundingMode.HALF_EVEN);

        return new PostFixedCdbResponse(
                data.getCdbName(),
                data.getInvestmentCategory(),
                data.getTitleCategory(),
                data.getApplicationAmount(),
                grossValue,
                incomeTax,
                finalAmount,
                worthValue
        );
    }

    @Override
    public PreFixedCdb calculate(PreFixedCdb data) {
        return null;
    }
}
