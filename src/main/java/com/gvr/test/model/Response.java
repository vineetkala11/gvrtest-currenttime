package com.gvr.test.model;

import lombok.Data;

@Data
public class Response {

    private String timestamp;
    private int calls ;
    
    public Response(String timestamp) {
        this.timestamp = timestamp;
        this.calls = Session.apiHitCount;
    }
    
}
