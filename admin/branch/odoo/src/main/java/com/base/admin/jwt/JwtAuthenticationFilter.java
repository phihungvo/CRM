package com.base.admin.jwt;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.base.admin.constant.FilterConstant;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtUtils jwtUtils;
    private final UserDetailsServiceImpl userDetailsService;
    //    private final TokenRepository tokenRepository;

    public JwtAuthenticationFilter(JwtUtils jwtUtils, UserDetailsServiceImpl userDetailsService) {
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
        //        this.tokenRepository = tokenRepository;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        if (Arrays.stream(FilterConstant.FILTER_WHITELIST).parallel().anyMatch(request.getServletPath()::contains)) {
            filterChain.doFilter(request, response);
            return;
        }

        // https://medium.com/@truongbui95/jwt-authentication-and-authorization-with-spring-boot-3-and-spring-security-6-2f90f9337421
        // https://www.geeksforgeeks.org/spring-boot-3-0-jwt-authentication-with-spring-security-using-mysql-database/
        try {
            String jwt = parseJwt(request);
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                String username = jwtUtils.getUserNameFromJwtToken(jwt);

                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                //            if (jwtService.isTokenValid(jwt, userDetails)) {
                //                Boolean isTokenValid = tokenRepository.findByToken(jwt)
                //                        .map(t -> !t.isExpired() && !t.isRevoked())
                //                        .orElse(false);
                //                if (isTokenValid) {

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
                //            }
            }
        } catch (Exception e) {
            //            e.printStackTrace();
        }
        filterChain.doFilter(request, response);
        //        if (StringUtils.isEmpty(authHeader) || !StringUtils.startsWith(authHeader, "Bearer ")) {
        //            filterChain.doFilter(request, response);
        //            return;
        //        }
        //        jwt = authHeader.substring(7);
        //        username = jwtService.extractUserName(jwt);
        //        if (StringUtils.isNotEmpty(username) && SecurityContextHolder.getContext().getAuthentication() ==
        // null) {
        ////            UserDetails userDetails = userService.userDetailsService().loadUserByUsername(username);
        //            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        //            if (jwtService.isTokenValid(jwt, userDetails)) {
        //                Boolean isTokenValid = tokenRepository.findByToken(jwt)
        //                        .map(t -> !t.isExpired() && !t.isRevoked())
        //                        .orElse(false);
        //                if (isTokenValid) {
        ////                SecurityContext context = SecurityContextHolder.createEmptyContext();
        //                    UsernamePasswordAuthenticationToken authToken = new
        // UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        //                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        ////                context.setAuthentication(authToken);
        ////                SecurityContextHolder.setContext(context);
        //                    SecurityContextHolder.getContext().setAuthentication(authToken);
        //                }
        //            }
        //        }
        //        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (org.springframework.util.StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }

        return null;
    }
}
