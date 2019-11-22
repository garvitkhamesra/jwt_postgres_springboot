package com.garvit.fylebackend.api.controller;

import com.garvit.fylebackend.api.domain.request.PaginationDetails;
import com.garvit.fylebackend.api.service.BankDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * User: garvit
 * Date: 12/11/19 2:42 PM
 */

@RestController
public class BankController {

    @Autowired
    private BankDetailService bankDetailService;

    @GetMapping(value = "/bank/branches")
    public ResponseEntity getBranchDetailFromIFSC(@RequestParam String ifsc) {
        return ResponseEntity.ok(bankDetailService.getBranchDetailFromIFSC(ifsc));
    }

    @PostMapping(value = "/bank")
    public ResponseEntity getBankDetailsFrom(@RequestParam String name, @RequestParam String city,
                                             @RequestBody PaginationDetails paginationDetails) {
        return ResponseEntity.ok(bankDetailService.getBankDetailsFromRequest(name, city, paginationDetails));
    }
}
