package com.neidev.invp.service;

import com.neidev.invp.domain.core.cdb.model.PostFixedCdb;
import com.neidev.invp.domain.core.cdb.model.PreFixedCdb;
import com.neidev.invp.domain.core.cdb.response.PostFixedCdbResponse;

public interface CdbServiceUseCase {

    public PostFixedCdbResponse calculate(PostFixedCdb data);
    public PreFixedCdb calculate(PreFixedCdb data);
}
