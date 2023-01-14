package ru.platform.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.platform.demo.models.SignIn;

@Repository
public interface SignInRepository extends JpaRepository<SignIn, Long> { }