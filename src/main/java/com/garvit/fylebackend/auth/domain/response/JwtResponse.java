package com.garvit.fylebackend.auth.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * User: garvit
 * Date: 12/11/19 3:00 PM
 */

@Data
@AllArgsConstructor
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8505241234399274840L;

    private String token;

}
