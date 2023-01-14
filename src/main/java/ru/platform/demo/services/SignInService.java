package ru.platform.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.platform.demo.models.SignIn;
import ru.platform.demo.repository.SignInRepository;
import ru.platform.demo.services.exceptions.IncorrectEmailException;
import ru.platform.demo.services.exceptions.IncorrectPasswordException;
import ru.platform.demo.services.interfaces.ISignInService;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SignInService implements ISignInService {
    @Autowired
    private final AccountService accountService;

    @Autowired
    private final SignInRepository signInRepository;

    @Override
    public SignIn openAccountProfile(SignIn signIn)
            throws IncorrectEmailException, IncorrectPasswordException {
        if (!accountService.isEmailExist(signIn.getEmail())) {
            throw new IncorrectEmailException("Почта с адрсом: " + signIn.getEmail() + " не была зарегистрирована");
        }

        if (!accountService.isPasswordCorrect(signIn.getEmail(), signIn.getPassword())) {
            throw new IncorrectPasswordException("Введенный пароль не является верным");
        }
        signIn.setSignInDate(String.valueOf(LocalDate.now()));
        return signInRepository.save(signIn);
    }

    public String returnNameOfLastUser() {
        List<SignIn> signInList = signInRepository.findAll();
        return signInList.size() != 0 ?
                accountService.getNameByEmail(signInList.get(signInList.size() - 1).getEmail()) : null;
    }
}