package ru.oogis.sns.ships.service;

import org.springframework.stereotype.Component;
import ru.oogis.sns.ships.data.entity.BerthEntity;
import ru.oogis.sns.ships.data.entity.ShipEntity;
import ru.oogis.sns.ships.exeption.ResourceNotFoundException;

import java.util.List;

@Component
public interface BerthService {
    List<BerthEntity> getAllBerth();

    BerthEntity createBerth(BerthEntity berthEntity);

    void deleteBerthEntityFromRepository(Long berthId);

    BerthEntity updateBerthEntity(Long berthId, BerthEntity berthEntity);

    List<BerthEntity> getListOfBerthInCity(String location);

    int getAmountShipsInBerth(BerthEntity berth);

    BerthEntity getBerthById(Long berthId) throws ResourceNotFoundException;

    List<ShipEntity> getListOfEachShipInCity(String location);

    void connectShipToBerthByID(Long shipId, Long berthId);

    void removeShipFromBerthByID(Long shipId, Long berthId);
}
