package com.demo.project.mvc.common.provider;

import com.demo.project.mvc.model.datamodel.LoginUser;
import com.demo.project.mvc.model.datamodel.TokenDataModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by saif on 4/6/15.
 */
@Component
public class UserAuthenticationSuccess  extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String redirectUrl = "/";
        if (auth != null) {

            TokenDataModel loginUser = ((TokenDataModel) auth.getPrincipal());
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
            request.getSession().setAttribute("userName", loginUser.getUserName());
//            request.getSession().setAttribute("fullName", loginUser.getToken());
//            request.getSession().setAttribute("gender", loginUser.getUserId());
//            request.getSession().setAttribute("mobileNo", loginUser.getUserStatus());
//            request.getSession().setAttribute("email", loginUser.getLoginMessage());
            redirectUrl="/home";
        }
        response.sendRedirect(redirectUrl);
        super.onAuthenticationSuccess(request, response, authentication);
    }

}
