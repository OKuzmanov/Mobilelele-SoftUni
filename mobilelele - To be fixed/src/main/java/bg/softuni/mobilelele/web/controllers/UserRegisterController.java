package bg.softuni.mobilelele.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserRegisterController {

    @GetMapping(value = "/users/register")
    public ModelAndView getUserRegister() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("auth-register");
        return modelAndView;
    }

    @PostMapping(value = "/users/%20/users/register")
    public ModelAndView registerUser() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users/login");
        return modelAndView;
    }
}
