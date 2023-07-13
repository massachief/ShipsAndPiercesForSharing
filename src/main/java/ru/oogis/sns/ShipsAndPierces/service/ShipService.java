package ru.oogis.sns.ShipsAndPierces.service;

import ru.oogis.sns.ShipsAndPierces.data.entity.ShipEntity;

import java.util.List;
import java.util.Optional;

public interface ShipService {
    Optional<ShipEntity> updateShipInList(Long shipId, ShipEntity shipEntity);

    List<ShipEntity> getAllShip();

    void addShipToList(ShipEntity shipEntity);

    void deleteShipEntityFromRepository(Long shipId);

    ShipEntity createShip(ShipEntity shipEntity);
}
