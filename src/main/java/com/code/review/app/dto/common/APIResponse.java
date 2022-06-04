package com.code.review.app.dto.common;

import lombok.Data;

import java.io.Serializable;


@Data
public class APIResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Boolean success = Boolean.TRUE;
    private String message;
    private T body;
}
