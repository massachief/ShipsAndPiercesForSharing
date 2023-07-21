package ru.oogis.sns.ShipsAndPierces.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.oogis.sns.ShipsAndPierces.data.entity.ShipEntity;

import java.util.List;
import java.util.Optional;
@Component
public interface ShipService {
    Optional<ShipEntity> updateShipInRepository(Long shipId, ShipEntity shipEntity);

    List<ShipEntity> getAllShip();

    void deleteShipEntityFromRepository(Long shipId);

    ShipEntity createShip(ShipEntity shipEntity);
}
