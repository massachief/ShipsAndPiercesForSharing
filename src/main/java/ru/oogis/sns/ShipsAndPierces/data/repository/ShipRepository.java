package ru.oogis.sns.ShipsAndPierces.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.oogis.sns.ShipsAndPierces.data.entity.ShipEntity;

import java.util.ArrayList;
import java.util.List;

public interface ShipRepository extends JpaRepository<ShipEntity, Integer> {
}
