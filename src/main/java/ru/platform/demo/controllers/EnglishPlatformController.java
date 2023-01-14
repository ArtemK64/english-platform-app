package ru.platform.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.platform.demo.services.SignInService;

@Controller
@RequiredArgsConstructor
public class EnglishPlatformController {
    @Autowired
    private final SignInService signInService;
    @GetMapping("/main")
    public String mainPage(Model model) {
        model.addAttribute("usersFirstName", "Здравствуйте, " +
                signInService.returnNameOfLastUser());
        return "main";
    }

    @GetMapping("/about")
    public String aboutUsPage() {
        return "about";
    }

    @GetMapping("/video-content")
    public String videoContentPage() {
        return "video-content";
    }
}