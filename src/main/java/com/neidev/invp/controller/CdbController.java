package com.neidev.invp.controller;

import com.neidev.invp.domain.core.Cdb;
import com.neidev.invp.domain.core.CdbResponseForm;
import com.neidev.invp.service.CdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cdb")
public class CdbController {

    @Autowired
    private CdbService cdbService;

    @PostMapping
    public CdbResponseForm calculate(@RequestBody Cdb data) {
        return cdbService.calculate(data);
    }
}
