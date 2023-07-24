package com.example.korail.exception;

import lombok.Data;

@Data
public class StationErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

    public StationErrorResponse() {

    }

    public StationErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
