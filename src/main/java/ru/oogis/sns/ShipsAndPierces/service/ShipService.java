package ru.oogis.sns.ShipsAndPierces.service;

import ru.oogis.sns.ShipsAndPierces.data.entity.ShipEntity;

public interface ShipService {
    boolean updateShipInList(ShipEntity ship);

    void printAllShips();

    void addShipToList(ShipEntity shipEntity);

    boolean removeShipFromList(ShipEntity shipEntity);

    String createShip(ShipEntity shipEntity);
}
