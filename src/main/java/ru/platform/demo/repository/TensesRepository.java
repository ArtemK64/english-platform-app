package ru.platform.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.platform.demo.models.Tenses;

@Repository
public interface TensesRepository extends JpaRepository<Tenses, Long> { }