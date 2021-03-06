package com.hxgis.authserver.controller;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class OAuthController {
    @RequestMapping("/exit")
    public void exit(HttpServletRequest request, HttpServletResponse response,String redirecturl) {
        // token can be revoked here if needed
        new SecurityContextLogoutHandler().logout(request, null, null);
        try {
            //sending back to client app
            response.sendRedirect(redirecturl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
