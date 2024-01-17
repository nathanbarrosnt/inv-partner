package com.neidev.invp.service;

import com.neidev.invp.domain.core.Cdb;
import com.neidev.invp.domain.core.CdbResponseForm;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

// vf = vp(1 + i)^n
// tx = cdi/100 * di;

@Service
public class CdbService {

    public CdbResponseForm calculate(Cdb data) {
        var porcentagemCdi = data.getPorcentagemCdi()
                .divide(BigDecimal.valueOf(100))
                .setScale(2, RoundingMode.HALF_DOWN);

        var taxa = porcentagemCdi
                .multiply(BigDecimal.valueOf(11.65))
                .divide(BigDecimal.valueOf(100))
                .setScale(2, RoundingMode.HALF_EVEN);

        var indice = new BigDecimal(1)
                .add(taxa)
                .setScale(2, RoundingMode.HALF_DOWN);

        var valorBruto = data.getValorAplicacao()
                .multiply(indice)
                .pow(1)
                .setScale(2, RoundingMode.HALF_EVEN);

        var impostoRenda = valorBruto
                .subtract(data.getValorAplicacao())
                .multiply(BigDecimal.valueOf(0.20))
                .setScale(2, RoundingMode.HALF_EVEN);

        var valorLiquido = valorBruto
                .subtract(impostoRenda)
                .setScale(2, RoundingMode.HALF_EVEN);

        var rendimentoLiquido = valorLiquido
                .subtract(data.getValorAplicacao())
                .setScale(2, RoundingMode.HALF_EVEN);

        return new CdbResponseForm(data.getNome(), data.getValorAplicacao(),
                valorBruto, impostoRenda, valorLiquido, rendimentoLiquido);
    }
}
