package com.store.util;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class SecutiryUtils {

    public static final String ROLE_PREFIX = "ROLE_";
    public static final String AUTH_HEADER = "authorization";
    public static final String AUTH_TOKEN = "Bearer";
    public static final String AUTH_TOKEN_PREFIX =AUTH_TOKEN + " ";

    public static SimpleGrantedAuthority convertToAuthority(String role) {
        String format = role.startsWith(ROLE_PREFIX) ? role :ROLE_PREFIX + role;
        return new SimpleGrantedAuthority(format);
    }

    public static String extractAuthFromUser(HttpServletRequest request) {
        String bearer = request.getHeader(AUTH_HEADER);

        if (StringUtils.hasLength(bearer) && bearer.startsWith(AUTH_TOKEN_PREFIX)) {
            return bearer.substring(7);
        }
        return null;
    }
}
