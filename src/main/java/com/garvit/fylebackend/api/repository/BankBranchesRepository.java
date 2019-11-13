package com.garvit.fylebackend.api.repository;

import com.garvit.fylebackend.api.dao.BankBranchesDetails;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * User: garvit
 * Date: 13/11/19 9:35 AM
 */
public interface BankBranchesRepository extends CrudRepository<BankBranchesDetails, String> {
    List<BankBranchesDetails> findByBankNameAndCity(String bankName, String city, Pageable pageable);
}
