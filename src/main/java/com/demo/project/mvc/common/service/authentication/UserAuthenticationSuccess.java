package com.demo.project.mvc.common.service.authentication;

import com.demo.project.mvc.model.datamodel.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by saif on 4/6/15.
 */
public class UserAuthenticationSuccess  extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String redirectUrl = "/";
        if (auth != null) {

            LoginUser loginUser = ((LoginUser) auth.getPrincipal());
            String userName = loginUser.getUserName();
            if (request.getParameter("_spring_security_remember_me") != null) {

                Cookie cookie = new Cookie("userName", userName);
                int cookieAge = 60 * 60 * 24 * 365 * 1;
                cookie.setMaxAge(cookieAge);
                response.addCookie(cookie);

            } else {
                Cookie cookie = new Cookie("userName", "");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
            redirectUrl="/home";
        }
        response.sendRedirect(redirectUrl);
        super.onAuthenticationSuccess(request, response, authentication);
    }

}
