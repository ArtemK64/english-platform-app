package ru.platform.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.platform.demo.models.Tenses;
import ru.platform.demo.services.TensesService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class TensesController {
    @Autowired
    private final TensesService tensesService;
    @GetMapping("/exercises")
    public String exercisesPage() {
        return "exercises";
    }

    @GetMapping("/exercises/past-simple")
    public String pastSimpleExercisePage(@ModelAttribute("pastSimpleTense") Tenses pastSimpleTense) {
        return "past-simple";
    }

    @PostMapping("/exercises/past-simple")
    public String pastSimpleExercisePageAnswers(
            @ModelAttribute("pastSimpleTense")
            @Valid Tenses pastSimpleTense, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "past-simple";
        }
        pastSimpleTense.setNameOfTense("Past Simple");
        int pastSimpleExerciseResults = tensesService.saveAndGetResults(pastSimpleTense);
        model.addAttribute("pastSimpleExerciseResults",
                "Правильных ответов: " + pastSimpleExerciseResults);
        model.addAttribute("pastSimpleExerciseCorrectAnswers",
                "Решения: 1. work, 2. lives, 3. eats, 4. takes, 5. visit");
        return "past-simple-results";
    }

    @GetMapping("/exercises/past-continuous")
    public String pastContinuousExercisePage(@ModelAttribute("pastContinuousTense") Tenses pastContinuousTense) {
        return "past-continuous";
    }

    @PostMapping("/exercises/past-continuous")
    public String pastContinuousExercisePageAnswers(
            @ModelAttribute("pastContinuousTense")
            @Valid Tenses pastContinuousTense, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "past-continuous";
        }
        pastContinuousTense.setNameOfTense("Past Continuous");
        int pastContinuousExerciseResults = tensesService.saveAndGetResults(pastContinuousTense);
        model.addAttribute("pastContinuousExerciseResults",
                "Правильных ответов: " + pastContinuousExerciseResults);
        model.addAttribute("pastContinuousExerciseCorrectAnswers",
                "Решения: 1. were writing, 2. was working, 3. were watching, 4. playing, 5. drinking");
        return "past-continuous-results";
    }

    @GetMapping("/exercises/past-perfect")
    public String pastPerfectExercisePage(@ModelAttribute("pastPerfectTense") Tenses pastPerfectTense) {
        return "past-perfect";
    }

    @PostMapping("/exercises/past-perfect")
    public String pastPerfectExercisePageAnswers(
            @ModelAttribute("pastPerfectTense")
            @Valid Tenses pastPerfectTense, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "past-perfect";
        }
        pastPerfectTense.setNameOfTense("Past Perfect");
        int pastPerfectExerciseResults = tensesService.saveAndGetResults(pastPerfectTense);
        model.addAttribute("pastPerfectExerciseResults",
                "Правильных ответов: " + pastPerfectExerciseResults);
        model.addAttribute("pastPerfectExerciseCorrectAnswers",
                "Решения: 1. had finished, 2. had cleaned, 3. had done, 4. had had, 5. had studied");
        return "past-perfect-results";
    }

    @GetMapping("/exercises/present-simple")
    public String presentSimpleExercisePage(@ModelAttribute("presentSimpleTense") Tenses presentSimpleTense) {
        return "present-simple";
    }

    @PostMapping("/exercises/present-simple")
    public String presentSimpleExercisePageAnswers(
            @ModelAttribute("presentSimpleTense")
            @Valid Tenses presentSimpleTense, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "present-simple";
        }
        presentSimpleTense.setNameOfTense("Present Simple");
        int presentSimpleExerciseResults = tensesService.saveAndGetResults(presentSimpleTense);
        model.addAttribute("presentSimpleExerciseResults",
                "Правильных ответов: " + presentSimpleExerciseResults);
        model.addAttribute("presentSimpleExerciseCorrectAnswers",
                "Решения: 1. doesn't, 2. don't, 3. don't, 4. don't, 5. doesn't");
        return "present-simple-results";
    }

    @GetMapping("/exercises/present-continuous")
    public String presentContinuousExercisePage(
            @ModelAttribute("presentContinuousTense") Tenses presentContinuousTense) {
        return "present-continuous";
    }

    @PostMapping("/exercises/present-continuous")
    public String presentContinuousExercisePageAnswers(
            @ModelAttribute("presentContinuousTense")
            @Valid Tenses presentContinuousTense, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "present-continuous";
        }
        presentContinuousTense.setNameOfTense("Present Continuous");
        int presentContinuousExerciseResults = tensesService.saveAndGetResults(presentContinuousTense);
        model.addAttribute("presentContinuousExerciseResults",
                "Правильных ответов: " + presentContinuousExerciseResults);
        model.addAttribute("presentContinuousExerciseCorrectAnswers",
                "Решения: 1. am going, 2. is walking, 3. are painting, 4. are enjoying, 5. is sunbathing");
        return "present-continuous-results";
    }

    @GetMapping("/exercises/present-perfect")
    public String presentPerfectExercisePage(
            @ModelAttribute("presentPerfectTense") Tenses presentPerfectTense) {
        return "present-perfect";
    }

    @PostMapping("/exercises/present-perfect")
    public String presentPerfectExercisePageAnswers(
            @ModelAttribute("presentPerfectTense")
            @Valid Tenses presentPerfectTense, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "present-perfect";
        }
        presentPerfectTense.setNameOfTense("Present Perfect");
        int presentPerfectExerciseResults = tensesService.saveAndGetResults(presentPerfectTense);
        model.addAttribute("presentPerfectExerciseResults",
                "Правильных ответов: " + presentPerfectExerciseResults);
        model.addAttribute("presentPerfectExerciseCorrectAnswers",
                "Решения: 1. has been, 2. has known, 3. has lived, 4. has taken, 5. have done");
        return "present-perfect-results";
    }

    @GetMapping("/exercises/future-simple")
    public String futureSimpleExercisePage(
            @ModelAttribute("futureSimpleTense") Tenses futureSimpleTense) {
        return "future-simple";
    }

    @PostMapping("/exercises/future-simple")
    public String futureSimpleExercisePageAnswers(
            @ModelAttribute("futureSimpleTense")
            @Valid Tenses futureSimpleTense, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "future-simple";
        }
        futureSimpleTense.setNameOfTense("Future Simple");
        int futureSimpleExerciseResults = tensesService.saveAndGetResults(futureSimpleTense);
        model.addAttribute("futureSimpleExerciseResults",
                "Правильных ответов: " + futureSimpleExerciseResults);
        model.addAttribute("futureSimpleExerciseCorrectAnswers",
                "Решения: 1. will visit, 2. will play, 3. will go, 4. will write, 5. will do");
        return "future-simple-results";
    }

    @GetMapping("/exercises/future-continuous")
    public String futureContinuousExercisePage(@ModelAttribute("futureContinuousTense") Tenses futureContinuousTense) {
        return "future-continuous";
    }

    @PostMapping("/exercises/future-continuous")
    public String futureContinuousExercisePageAnswers(
            @ModelAttribute("futureContinuousTense")
            @Valid Tenses futureContinuousTense, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "future-continuous";
        }
        futureContinuousTense.setNameOfTense("Future Continuous");
        int futureContinuousExerciseResults = tensesService.saveAndGetResults(futureContinuousTense);
        model.addAttribute("futureContinuousExerciseResults",
                "Правильных ответов: " + futureContinuousExerciseResults);
        model.addAttribute("futureContinuousExerciseCorrectAnswers",
                "Решения: 1. will be working, 2. will be giving, 3. will be dancing, 4. will not be sleeping, 5. will be practicing");
        return "future-continuous-results";
    }

    @GetMapping("/exercises/future-perfect")
    public String futurePerfectExercisePage(@ModelAttribute("futurePerfectTense") Tenses futurePerfectTense) {
        return "future-perfect";
    }

    @PostMapping("/exercises/future-perfect")
    public String futurePerfectExercisePageAnswers(
            @ModelAttribute("futurePerfectTense")
            @Valid Tenses futurePerfectTense, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "future-perfect";
        }
        futurePerfectTense.setNameOfTense("Future Perfect");
        int futurePerfectExerciseResults = tensesService.saveAndGetResults(futurePerfectTense);
        model.addAttribute("futurePerfectExerciseResults",
                "Правильных ответов: " + futurePerfectExerciseResults);
        model.addAttribute("futurePerfectExerciseCorrectAnswers",
                "1. will have been, 2. will have finished, 3. will have been, " +
                        "4. will have started, 5. will have finished");
        return "future-perfect-results";
    }

    @GetMapping("/exercises/past-simple-rules")
    public String pastSimpleRulesPage() {
        return "past-simple-rules";
    }

    @GetMapping("/exercises/past-continuous-rules")
    public String pastContinuousRulesPage() {
        return "past-continuous-rules";
    }

    @GetMapping("/exercises/past-perfect-rules")
    public String pastPerfectRulesPage() {
        return "past-perfect-rules";
    }

    @GetMapping("/exercises/present-simple-rules")
    public String presentSimpleRulesPage() {
        return "present-simple-rules";
    }

    @GetMapping("/exercises/present-continuous-rules")
    public String presentContinuousRulesPage() {
        return "present-continuous-rules";
    }

    @GetMapping("/exercises/present-perfect-rules")
    public String presentPerfectRulesPage() {
        return "present-perfect-rules";
    }

    @GetMapping("/exercises/future-simple-rules")
    public String futureSimpleRulesPage() {
        return "future-simple-rules";
    }

    @GetMapping("/exercises/future-continuous-rules")
    public String futureContinuousRulesPage() {
        return "future-continuous-rules";
    }

    @GetMapping("/exercises/future-perfect-rules")
    public String futurePerfectRulesPage() {
        return "future-perfect-rules";
    }
}