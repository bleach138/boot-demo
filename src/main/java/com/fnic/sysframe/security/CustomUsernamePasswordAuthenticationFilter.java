package com.fnic.sysframe.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;

/**
 * Created by hjhuang on 2017/5/17.
 */
public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if ("application/json".equals(request.getHeader("Content-Type"))) {
            try {
                /*
                 * HttpServletRequest can be read only once
                 */
                StringBuffer sb = new StringBuffer();
                String line = null;

                BufferedReader reader = request.getReader();
                while ((line = reader.readLine()) != null){
                    sb.append(line);
                }

                //json transformation
                ObjectMapper mapper = new ObjectMapper();
                LoginRequest loginRequest = mapper.readValue(sb.toString(), LoginRequest.class);

                UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword());

                this.setDetails(request, authRequest);
                return this.getAuthenticationManager().authenticate(authRequest);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return super.attemptAuthentication(request, response);
    }


}
