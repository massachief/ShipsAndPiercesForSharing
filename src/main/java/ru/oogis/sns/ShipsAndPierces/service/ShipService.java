package ru.oogis.sns.ShipsAndPierces.service;

import ru.oogis.sns.ShipsAndPierces.data.entity.ShipEntity;

import java.util.Optional;

public interface ShipService {
    Optional<ShipEntity> updateShipInList(Long shipId, ShipEntity shipEntity);

    void printAllShips();

    void addShipToList(ShipEntity shipEntity);

    void deleteShipEntityFromRepository(Long shipId);

    String createShip(ShipEntity shipEntity);
}
