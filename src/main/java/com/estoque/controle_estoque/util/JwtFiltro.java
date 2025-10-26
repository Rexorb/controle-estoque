package com.estoque.controle_estoque.util;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFiltro implements Filter{

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;

        String path = request.getRequestURI();

        if(path.startsWith("/protected")){
            String authHeader = request.getHeader("Authorization");

            if(authHeader != null && authHeader.startsWith("Bearer ")){
                String token = authHeader.replace("Bearer ","");
                try{
                    String user = JwtUtil.getTokenUser(token);
                    String email = JwtUtil.getTokenEmail(token);

                    CustomUserDetails userDetails = new CustomUserDetails(user, email);

                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());

                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                }catch(Exception e){
                    ((HttpServletResponse) resp).sendError(HttpServletResponse.SC_UNAUTHORIZED,"Token Inválido");
                }
            }else{
                ((HttpServletResponse) resp).sendError(HttpServletResponse.SC_BAD_REQUEST,"Token Ausente");
            }
        }
    }
    
}
