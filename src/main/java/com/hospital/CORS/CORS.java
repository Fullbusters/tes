package com.hospital.CORS;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CORS implements Filter {

    // тут має бути мій сервер але тепер буде доступ для всіх
    private static final String AllowedOrigin = "Origin";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest requestToUse = (HttpServletRequest) servletRequest;
        HttpServletResponse responseToUse = (HttpServletResponse) servletResponse;

        String incomingOriginFromRequest = requestToUse.getHeader("Origin");


        if (AllowedOrigin.contains(incomingOriginFromRequest)){
            responseToUse.setHeader("access-control-allow-origin",incomingOriginFromRequest);
        }
        filterChain.doFilter(requestToUse, responseToUse);
    }

    @Override
    public void destroy() {

    }
}
