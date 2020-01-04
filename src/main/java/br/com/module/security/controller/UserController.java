package br.com.module.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @RequestMapping(value = "/welcome", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String welcome(Model model, HttpSession session) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return String.format("Bem vindo, %s", authentication.getName());
    }

    @GetMapping("/dashboard")
    @ResponseBody
    public String dashboard(){
        return "Bem vindo, este é o dashboard, você está logado!";
    }


}
