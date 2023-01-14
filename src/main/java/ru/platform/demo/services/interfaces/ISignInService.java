package ru.platform.demo.services.interfaces;

import ru.platform.demo.models.SignIn;
import ru.platform.demo.services.exceptions.IncorrectEmailException;
import ru.platform.demo.services.exceptions.IncorrectPasswordException;

public interface ISignInService {
    SignIn openAccountProfile(SignIn signIn) throws IncorrectEmailException, IncorrectPasswordException;
}