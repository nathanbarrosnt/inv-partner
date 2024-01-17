package com.neidev.invp.controller;

import com.neidev.invp.domain.core.cdb.model.PostFixedCdb;
import com.neidev.invp.domain.core.cdb.response.PostFixedCdbResponse;
import com.neidev.invp.service.impl.CdbServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cdb")
public class CdbController {

    private final CdbServiceImpl cdbServiceImpl;

    public CdbController(CdbServiceImpl cdbServiceImpl) {
        this.cdbServiceImpl = cdbServiceImpl;
    }

    @PostMapping("/pos")
    public ResponseEntity<PostFixedCdbResponse> calculate(@RequestBody PostFixedCdb data) {
        return new ResponseEntity<>(cdbServiceImpl.calculate(data), HttpStatus.OK);
    }


}
