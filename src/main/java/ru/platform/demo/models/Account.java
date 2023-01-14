package ru.platform.demo.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import ru.platform.demo.annotations.ValidEnglishLevel;
import ru.platform.demo.annotations.ValidName;
import ru.platform.demo.annotations.ValidPassword;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity(name = "account")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 100, message = "Имя должно быть в диапазоне от 2 до 100 букв")
    @NotEmpty(message = "Данное поле должно быть заполненым")
    @ValidName(message = "Имя может состоять только из букв (кириллица)")
    private String firstName;

    @Size(min = 2, max = 100, message = "Фамилия должна быть в диапазоне от 2 до 100 букв")
    @NotEmpty(message = "Данное поле должно быть заполненым")
    @ValidName(message = "Фамилия может состоять только из букв (кириллица)")
    private String lastName;

    @NotEmpty(message = "Данное поле должно быть заполненым")
    @ValidEnglishLevel
    private String levelOfEnglish;

    @Email(message = "Должен иметь формат адреса электронной почты")
    @NotEmpty(message = "Данное поле должно быть заполненым")
    private String email;

    @NotEmpty(message = "Данное поле должно быть заполненым")
    @ValidPassword
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Account account = (Account) o;
        return id != null && Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}