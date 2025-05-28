package com.example.demo.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

// This class is filter for API key. It checks every request for correct key, but skips H2 console.
@Component
public class ApiKeyFilter extends OncePerRequestFilter {
    private static final String API_KEY_HEADER = "X-API-Key";

    @Value("${security.api.key}")
    private String validApiKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String path = request.getRequestURI();

        // Allow access to H2 console without API key
        if (path.startsWith("/h2-console")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Check API key for all other requests
        String apiKey = request.getHeader(API_KEY_HEADER);
        if (!validApiKey.equals(apiKey)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("{\"error\": \"Invalid API Key\"}");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
