package com.demo.project.mvc.common.provider;

import com.demo.project.mvc.common.service.authentication.TokenService;
import com.demo.project.mvc.model.datamodel.TokenDataModel;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    TokenService tokenService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String redirectUrl="/logout";
        if(authentication!= null){
            TokenDataModel tokenDataModel= (TokenDataModel) authentication.getPrincipal();
            String tokenString=tokenDataModel.getToken();
            tokenService.deleteUserToken(tokenString);
        }
        request.getSession().invalidate();
        response.sendRedirect(redirectUrl);
        super.onLogoutSuccess(request, response, authentication);
    }

}
