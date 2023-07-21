package ru.oogis.sns.ShipsAndPierces.service;

import org.springframework.stereotype.Component;
import ru.oogis.sns.ShipsAndPierces.data.entity.BerthEntity;
import ru.oogis.sns.ShipsAndPierces.data.entity.ShipEntity;
import ru.oogis.sns.ShipsAndPierces.exeption.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Component
public interface BerthService {
    List<BerthEntity> getAllBerth();

    BerthEntity createBerth(BerthEntity berthEntity);

    void deleteBerthEntityFromRepository(Long berthId);

    Optional<BerthEntity> updateBerthEntity(Long berthId, BerthEntity berthEntity);

    List<BerthEntity> getListOfBerthInCity(String location);

    int getAmountShipsInBerth(BerthEntity berth);

    BerthEntity getBerthById(Long berthId) throws ResourceNotFoundException;

    List<ShipEntity> getListOfEachShipInCity(String location);

    void connectShipToBerthByID(Long shipId, Long berthId);

    void removeShipFromBerthByID(Long shipId, Long berthId);
}
