package ru.platform.demo.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity(name = "tenses")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Tenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameOfTense;
    @NotEmpty(message = "Данная строка не может быть пустой")
    private String firstAnswer;
    @NotEmpty(message = "Данная строка не может быть пустой")
    private String secondAnswer;
    @NotEmpty(message = "Данная строка не может быть пустой")
    private String thirdAnswer;
    @NotEmpty(message = "Данная строка не может быть пустой")
    private String fourthAnswer;
    @NotEmpty(message = "Данная строка не может быть пустой")
    private String fifthAnswer;
    private Integer qtyOfCorrectAnswers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Tenses tenses = (Tenses) o;
        return id != null && Objects.equals(id, tenses.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public List<String> getListOfAnswers() {
        return removeSpacesFromAnswers(
                getFirstAnswer(),
                getSecondAnswer(),
                getThirdAnswer(),
                getFourthAnswer(),
                getFifthAnswer()
        );
    }

    private List<String> removeSpacesFromAnswers(String... answer) {
        return Arrays.stream(answer).map(String::trim).toList();
    }

    public Tenses removeSpacesBeforeSaving(Tenses tenses) {
        tenses.firstAnswer = firstAnswer.trim();
        tenses.secondAnswer = secondAnswer.trim();
        tenses.thirdAnswer = thirdAnswer.trim();
        tenses.fourthAnswer = fourthAnswer.trim();
        tenses.fifthAnswer = fifthAnswer.trim();
        return tenses;
    }
}