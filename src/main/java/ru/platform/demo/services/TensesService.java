package ru.platform.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.platform.demo.models.Tenses;
import ru.platform.demo.repository.TensesRepository;
import ru.platform.demo.services.interfaces.ITensesService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TensesService implements ITensesService {
    @Autowired
    private final TensesRepository tensesRepository;

    @Override
    public int saveAndGetResults(Tenses tenses) {
        switch (tenses.getNameOfTense()) {
            case "Past Simple" -> {
                return saveTenses(
                        List.of("work", "lives", "eats", "takes", "visit"),
                        tenses);
            }
            case "Past Continuous" -> {
                return saveTenses(
                        List.of("were writing", "was working", "were watching", "playing", "drinking"),
                        tenses);
            }
            case "Past Perfect" -> {
                return saveTenses(
                        List.of("had finished", "had cleaned", "had done", "had had", "had studied"),
                        tenses);
            }
            case "Present Simple" -> {
                return saveTenses(
                        List.of("doesn't", "don't", "don't", "don't", "doesn't"),
                        tenses);
            }
            case "Present Continuous" -> {
                return saveTenses(
                        List.of("am going", "is walking", "are painting", "are enjoying", "is sunbathing"),
                        tenses);
            }
            case "Present Perfect" -> {
                return saveTenses(
                        List.of("has been", "has known", "has lived", "has taken", "have done"),
                        tenses);
            }
            case "Future Simple" -> {
                return saveTenses(
                        List.of("will visit", "will play", "will go", "will write", "will do"),
                        tenses);
            }
            case "Future Continuous" -> {
                return saveTenses(
                        List.of("will be working",
                                "will be giving",
                                "will be dancing",
                                "will not be sleeping",
                                "will be practicing"),
                        tenses);
            }
            default -> { // Future Perfect
                return saveTenses(
                        List.of("will have been",
                                "will have finished",
                                "will have been",
                                "will have started",
                                "will have finished"),
                        tenses);
            }
        }
    }

    private int saveTenses(List<String> correctAnswers, Tenses tenses) {
        tenses.setQtyOfCorrectAnswers(checkAnswersAndGetResults(
                correctAnswers, tenses.getListOfAnswers()));
        tensesRepository.save(tenses.removeSpacesBeforeSaving(tenses));
        return tenses.getQtyOfCorrectAnswers();
    }

    private int checkAnswersAndGetResults(List<String> correctAnswers, List<String> userAnswers) {
        int count = 0;
        for (int i = 0; i < correctAnswers.size(); i++) {
            if (correctAnswers.get(i).equalsIgnoreCase(userAnswers.get(i))) {
                count++;
            }
        }
        return count;
    }
}