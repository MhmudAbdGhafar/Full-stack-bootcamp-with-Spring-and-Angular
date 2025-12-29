package com.example.springboot3jwtauthentication.filters;

import com.example.springboot3jwtauthentication.services.JwtService;
import com.example.springboot3jwtauthentication.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;

        if (
                StringUtils.isEmpty(authHeader) ||
                !StringUtils.startsWith(authHeader, "Bearer ")
        ) {

            filterChain.doFilter(request, response);

            return;
        }

        jwt = authHeader.substring(7);

        log.debug("JWT - {}", jwt);

        userEmail = jwtService.extractUserName(jwt);

        if (
                StringUtils.isNotEmpty(userEmail) &&
                SecurityContextHolder.getContext().getAuthentication() == null
        ) {

            UserDetails userDetails;
            userDetails = userService.userDetailsService().loadUserByUsername(userEmail);

            if (jwtService.isTokenValid(jwt, userDetails)) {

                log.debug("User - {}", userDetails);

                /*
                UsernamePasswordAuthenticationToken authToken;
                authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContext context = SecurityContextHolder.createEmptyContext();
                context.setAuthentication(authToken);

                SecurityContextHolder.setContext(context);
                */


                Authentication authToken;
                authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}