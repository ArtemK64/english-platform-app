package ru.platform.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.platform.demo.models.Account;
import ru.platform.demo.models.SignIn;
import ru.platform.demo.repository.AccountRepository;
import ru.platform.demo.repository.SignInRepository;
import ru.platform.demo.services.exceptions.AccountIsAlreadyExistException;
import ru.platform.demo.services.interfaces.IAccountService;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService {
    @Autowired
    private final AccountRepository accountRepository;
    @Autowired
    private final SignInRepository signInRepository;
    @Override
    public Account registerNewAccount(Account account) throws AccountIsAlreadyExistException {
        if (isEmailExist(account.getEmail())) {
            throw new AccountIsAlreadyExistException(
                    "Аккаунт с электронной почтой: " + account.getEmail() +  " уже был зарегистрирован");
        }
        signInRepository.save(new SignIn(account.getEmail(), account.getPassword(), String.valueOf(LocalDate.now())));
        return accountRepository.save(account);
    }

    public boolean isEmailExist(String email) {
        List<Account> accounts = accountRepository.findAll();
        for (Account account: accounts) {
            if (account.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPasswordCorrect(String email, String password) {
        List<Account> accounts = accountRepository.findAll();
        for (Account account: accounts) {
            if (account.getEmail().equalsIgnoreCase(email) && account.getPassword().equalsIgnoreCase(password)) {
                return true;
            }
        }
        return false;
    }

    public String getNameByEmail(String email) {
        List<Account> accounts = accountRepository.findAll();
        for (Account account: accounts) {
            if (account.getEmail().equalsIgnoreCase(email)) {
                return account.getFirstName();
            }
        }
        return null;
    }
}