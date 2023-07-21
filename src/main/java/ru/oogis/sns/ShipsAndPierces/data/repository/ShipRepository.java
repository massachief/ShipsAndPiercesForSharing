package ru.oogis.sns.ShipsAndPierces.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.oogis.sns.ShipsAndPierces.data.entity.ShipEntity;

@Repository
public interface ShipRepository extends JpaRepository<ShipEntity, Long> {
}
