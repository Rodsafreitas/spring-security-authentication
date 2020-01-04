package br.com.module.security.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SuccessAutenthication  implements AuthenticationSuccessHandler
{

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        //Setting 15 seconds to the time of session
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.setMaxInactiveInterval(15);
        }

        response.sendRedirect("/welcome");

    }
}
