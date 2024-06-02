package com.tang.atpsimple.web.service;

import com.tang.atpsimple.web.request.DebugRequest;

public interface DebugService {


    /**
     * @param debugRequest
     * @return
     */
    String http(DebugRequest debugRequest);

}
