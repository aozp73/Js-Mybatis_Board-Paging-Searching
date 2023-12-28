package com.example.jsmybatis_pagingsearching.config.security.jwt;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.jsmybatis_pagingsearching.config.security.principal.PrincipalDetails;
import com.example.jsmybatis_pagingsearching.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private JwtUtil jwtUtil;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        super(authenticationManager);
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String prefixJwt = request.getHeader(jwtUtil.HEADER);

        if (prefixJwt == null) {
            chain.doFilter(request, response);
            return;
        }
        String jwt = prefixJwt.replace(JwtUtil.TOKEN_PREFIX, "");
        try {
            DecodedJWT decodedJWT = jwtUtil.verify(jwt);
            Long id = decodedJWT.getClaim("id").asLong();
            String email = decodedJWT.getClaim("email").asString();
            String role = decodedJWT.getClaim("role").asString();

            User user = User.builder().id(id).email(email).role(role).build();

            PrincipalDetails myUserDetails = new PrincipalDetails(user);
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    myUserDetails,
                    myUserDetails.getPassword(),
                    myUserDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (TokenExpiredException tee) {
            log.error("토큰 만료됨");
        } catch (Exception sve) {
            log.error("토큰 검증 실패", sve);
        } finally {
            chain.doFilter(request, response);
        }
    }
}
