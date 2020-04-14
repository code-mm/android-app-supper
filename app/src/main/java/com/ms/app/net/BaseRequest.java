package com.ms.app.net;

import java.util.HashMap;
import java.util.Map;

public class BaseRequest {
    Map<String, String> headers = new HashMap<>();

    protected Map<String, String> headers() {
        headers.put("Content-Type", "application/json");
        return headers;
    }
}
