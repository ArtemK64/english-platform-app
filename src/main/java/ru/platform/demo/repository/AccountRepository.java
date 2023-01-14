package ru.platform.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.platform.demo.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> { }