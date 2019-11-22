package com.garvit.fylebackend.api.service.impl;

import com.garvit.fylebackend.api.dao.BankBranchesDetails;
import com.garvit.fylebackend.api.domain.request.PaginationDetails;
import com.garvit.fylebackend.api.repository.BankBranchesRepository;
import com.garvit.fylebackend.api.service.BankDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * User: garvit
 * Date: 13/11/19 12:21 PM
 */

@Service
public class BankDetailServiceImpl implements BankDetailService {

    private BankBranchesRepository bankBranchesRepository;

    @Autowired
    public BankDetailServiceImpl(BankBranchesRepository bankBranchesRepository) {
        this.bankBranchesRepository = bankBranchesRepository;
    }

    @Override
    public Optional getBranchDetailFromIFSC(String ifsc) {
        return bankBranchesRepository.findById(ifsc);
    }

    @Override
    public List<BankBranchesDetails> getBankDetailsFromRequest(String bankName, String city, PaginationDetails paginationDetails) {
        Pageable pageRequest = PageRequest.of(paginationDetails.getPage(), paginationDetails.getSize());
        return bankBranchesRepository.findByBankNameAndCity(bankName, city, pageRequest);
    }
}
