package com.garvit.fylebackend.api.dao;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: garvit
 * Date: 13/11/19 7:55 AM
 */

@Data
@Entity
@Table(name = "bank_branches")
public class BankBranchesDetails implements Serializable {

    private static final long serialVersionUID = -2003008875318335260L;

    @Id
    private String ifsc;

    @Column(name = "bank_id")
    private String bankId;

    private String branch;

    private String address;

    private String city;

    private String district;

    private String state;

    @Column(name = "bank_name")
    private String bankName;
}
