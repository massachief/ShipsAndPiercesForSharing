package ru.oogis.sns.ShipsAndPierces.service;

import ru.oogis.sns.ShipsAndPierces.data.entity.BerthEntity;
import ru.oogis.sns.ShipsAndPierces.exeption.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface BerthService {
    List<BerthEntity> getAllBerth();

    BerthEntity createBerth(BerthEntity berthEntity);

    void deleteBerthEntityFromRepository(Long berthId);

    Optional<BerthEntity> updateBerthEntity(Long berthId, BerthEntity berthEntity);

    List<BerthEntity> getListOfBerthInCity(String location);

    int getAmountShipsInBerth(BerthEntity berth);

    BerthEntity getBerthById(Long berthId) throws ResourceNotFoundException;

    List<BerthEntity> getListOfEachShipInCity(String location);

    void connectShipToBerthByID(Long shipId, Long berthId);

    void removeShipFromBerthByID(Long shipId, Long berthId);
}
