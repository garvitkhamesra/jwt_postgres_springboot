package com.garvit.fylebackend.auth.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * User: garvit
 * Date: 12/11/19 2:59 PM
 */

@Data
@AllArgsConstructor
public class LoginCredentials implements Serializable {

    private static final long serialVersionUID = -2852782807063381767L;

    private String username;
    private String password;
}
