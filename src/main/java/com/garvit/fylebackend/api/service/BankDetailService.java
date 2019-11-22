package com.garvit.fylebackend.api.service;

import com.garvit.fylebackend.api.dao.BankBranchesDetails;
import com.garvit.fylebackend.api.domain.request.PaginationDetails;

import java.util.List;
import java.util.Optional;

/**
 * User: garvit
 * Date: 13/11/19 12:29 PM
 */
public interface BankDetailService {
    Optional getBranchDetailFromIFSC(String ifsc);
    List<BankBranchesDetails> getBankDetailsFromRequest(String bankName, String city,
                                                        PaginationDetails paginationDetails);
}