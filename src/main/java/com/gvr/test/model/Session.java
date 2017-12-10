package com.gvr.test.model;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.gvr.test.util.Utils;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Session {

    public enum API {Time}
    // Here we can use Map to store multiple API hit counts
    public static volatile int apiHitCount;
    
    @PostConstruct
    public void sync() {
        try {
            apiHitCount = Utils.getCounter(API.Time);
        } catch (IOException e) {
            log.error("unable to update api hit count ",e);
            apiHitCount = 0;
        }
    }
    
    public void updateHitCount(API api) {
        try {
            apiHitCount = Utils.updateCounter(api);
        } catch (IOException e) {
            log.error("unable to update api hit count ",e);
            apiHitCount = 0;
        }
    }
}
