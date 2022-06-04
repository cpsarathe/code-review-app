package com.code.review.app.dto.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
    protected String password;

}
