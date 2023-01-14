package ru.platform.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.platform.demo.models.SignIn;
import ru.platform.demo.services.SignInService;
import ru.platform.demo.services.exceptions.IncorrectEmailException;
import ru.platform.demo.services.exceptions.IncorrectPasswordException;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class SignInController {
    @Autowired
    private final SignInService signInService;
    @GetMapping("/sign-in")
    public String signInPage(@ModelAttribute("signIn") SignIn signIn) {
        return "sign-in";
    }

    @GetMapping("/sign-in-err")
    public String signInErrPage() {
        return "sign-in-err";
    }

    @PostMapping("/sign-in")
    public String openAccountProfile(
            @ModelAttribute("signIn") @Valid SignIn signIn, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "sign-in";
        }
        try {
            SignIn signInUser = signInService.openAccountProfile(signIn);
        } catch (IncorrectEmailException | IncorrectPasswordException e) {
            model.addAttribute("signInErrMessage", e.getMessage());
            return "sign-in-err";
        }

        return "redirect:/main";
    }
}