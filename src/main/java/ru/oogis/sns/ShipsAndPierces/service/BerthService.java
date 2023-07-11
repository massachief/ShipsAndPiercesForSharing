package ru.oogis.sns.ShipsAndPierces.service;

import ru.oogis.sns.ShipsAndPierces.data.entity.BerthEntity;

public interface BerthService {
    void printAllBerths();

    void createBerth(BerthEntity berth);

    void deleteBerthEntityFromRepository(Long shipId);

    void editBerthInList();

    void getListOfBerthInCity();

    void getAmountShipsInBerth();

    void getListOfEachShipInCity();

    void connectShipToBerthByID(Long id);

    void removeShipFromBerthByID(Long id);
}
