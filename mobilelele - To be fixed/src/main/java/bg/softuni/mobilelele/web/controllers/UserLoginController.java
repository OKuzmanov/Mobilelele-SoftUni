package bg.softuni.mobilelele.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserLoginController {

    @GetMapping(value = "/users/login")
    public ModelAndView userLogin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("auth-login");
        return modelAndView;
    }
}
