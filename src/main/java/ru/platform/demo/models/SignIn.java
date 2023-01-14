package ru.platform.demo.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import ru.platform.demo.annotations.ValidPassword;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity(name = "sign_in")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SignIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email(message = "Должен иметь формат адреса электронной почты")
    @NotEmpty(message = "Данное поле должно быть заполненым")
    private String email;
    @ValidPassword
    @NotEmpty(message = "Данное поле должно быть заполненым")
    private String password;
    private String signInDate;

    public SignIn(String email, String password, String signInDate) {
        this.email = email;
        this.password = password;
        this.signInDate = signInDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SignIn signIn = (SignIn) o;
        return id != null && Objects.equals(id, signIn.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}