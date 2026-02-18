package com.sunidhi.springboot3versioning.interceptor;

import jakarta.annotation.Nonnull;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

@Component
public class ApiVersionInterceptor implements HandlerInterceptor {

    private static final List<String> SUPPORTED = List.of("1.0", "2.0");

    @Override
    public boolean preHandle(HttpServletRequest request,
                             @Nonnull HttpServletResponse response,
                             @Nonnull Object handler) throws Exception {

        String version = request.getHeader("API-Version");

        if (version != null && !SUPPORTED.contains(version)) {
            response.sendError(HttpStatus.BAD_REQUEST.value(),
                    "Invalid API Version");
            return false;
        }

        return true;
    }
}

