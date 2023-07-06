package ru.oogis.sns.ShipsAndPierces.service;

import ru.oogis.sns.ShipsAndPierces.data.entity.BerthEntity;

public interface BerthService {
    void printAllBerths();

    void addBertToList(BerthEntity berth);

    void removeBerthFromList(Long id);

    void editBerthInList();

    void getListOfBerthInCity();

    void getAmountShipsInBerth();

    void getListOfEachShipInCity();

    void connectShipToBerthByID(Long id);

    void removeShipFromBerthByID(Long id);
}
