package com.cv.util;

import java.util.UUID;

public class UUIDGenerator {

    public static String getUniqueUUID(){
        return UUID.randomUUID().toString();
    }
}
