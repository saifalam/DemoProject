package com.demo.project.mvc.common.provider;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by saif on 4/10/15.
 */
public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String redirectUrl="/logout";
        if(authentication!= null){

        }
        request.getSession().invalidate();
        response.sendRedirect(redirectUrl);
        super.onLogoutSuccess(request, response, authentication);
    }

}
