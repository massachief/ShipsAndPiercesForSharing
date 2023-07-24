package ru.oogis.sns.ships.service;

import org.springframework.stereotype.Component;
import ru.oogis.sns.ships.data.entity.ShipEntity;

import java.util.List;

@Component
public interface ShipService {
    ShipEntity updateShipInRepository(Long shipId, ShipEntity shipEntity);

    List<ShipEntity> getAllShip();

    void deleteShipEntityFromRepository(Long shipId);

    ShipEntity createShip(ShipEntity shipEntity);
}
