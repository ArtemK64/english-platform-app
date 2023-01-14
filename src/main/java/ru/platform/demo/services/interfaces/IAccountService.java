package ru.platform.demo.services.interfaces;

import ru.platform.demo.models.Account;
import ru.platform.demo.services.exceptions.AccountIsAlreadyExistException;

public interface IAccountService {
    Account registerNewAccount(Account account) throws AccountIsAlreadyExistException;
}