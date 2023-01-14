package ru.platform.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.platform.demo.models.Account;
import ru.platform.demo.services.AccountService;
import ru.platform.demo.services.exceptions.AccountIsAlreadyExistException;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class AccountController {
    @Autowired
    private final AccountService accountService;
    @GetMapping("/sign-up")
    public String signUpPage(@ModelAttribute("account") Account account) {
        return "sign-up";
    }

    @GetMapping("/sign-up-err")
    public String signUpErrPage() {
        return "sign-up-err";
    }

    @PostMapping("/sign-up")
    public String registerAccount(
            @ModelAttribute("account") @Valid Account account, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "sign-up";
        }
        try {
            Account registredAccount = accountService.registerNewAccount(account);
        } catch (AccountIsAlreadyExistException e) {
            model.addAttribute("emailIsExistErr", e.getMessage());
            return "sign-up-err";
        }
        return "redirect:/main";
    }
}