package com.samet.coinApp;

import okhttp3.Headers;

public class HttpRequestHeader {
    public static Headers getHttpHeaders() {
        return new Headers.Builder()
                .add("Content-Type", "application/json")
                .add("Accept", "application/json")
                .add("X-CMC_PRO_API_KEY", "103725a7-8317-4e13-86eb-7cdc288f51ce").build();
    }

}