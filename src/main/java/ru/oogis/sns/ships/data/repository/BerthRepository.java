package ru.oogis.sns.ships.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.oogis.sns.ships.data.entity.BerthEntity;

@Repository
public interface BerthRepository extends JpaRepository<BerthEntity, Long> {
}