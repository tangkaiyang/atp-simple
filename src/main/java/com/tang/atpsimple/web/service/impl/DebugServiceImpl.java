package com.tang.atpsimple.web.service.impl;

import com.tang.atpsimple.web.request.DebugRequest;
import com.tang.atpsimple.web.service.DebugService;
import org.springframework.stereotype.Service;

@Service
public class DebugServiceImpl implements DebugService {
    /**
     * @param debugRequest
     * @return
     */
    @Override
    public String http(DebugRequest debugRequest) {
        return debugRequest.toString();
    }
}
