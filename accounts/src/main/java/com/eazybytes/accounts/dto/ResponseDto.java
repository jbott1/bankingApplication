package com.eazybytes.accounts.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ResponseDto {

    private String statusCode;

    private String statusMsg;

    public ResponseDto(String status201, String message201) {
    }
}
