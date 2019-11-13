package com.garvit.fylebackend.api.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * User: garvit
 * Date: 13/11/19 12:26 PM
 */

@Data
public class BankDetailRequest implements Serializable {
    private static final long serialVersionUID = -7063078197035474508L;

    private String bankName;
    private String city;
    private Integer page;
    private Integer size;
}
