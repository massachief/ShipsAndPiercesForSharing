package ru.oogis.sns.ships.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.oogis.sns.ships.data.entity.ShipEntity;
import ru.oogis.sns.ships.data.repository.ShipRepository;
import ru.oogis.sns.ships.exeption.ResourceNotFoundException;
import ru.oogis.sns.ships.service.ShipService;

import java.util.List;

@Service
public class ShipServiceImpl implements ShipService {
    @Autowired
    private final ShipRepository shipRepository;

    public ShipServiceImpl(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    @Override
    public ShipEntity createShip(ShipEntity shipEntity) {
        ShipEntity ship = new ShipEntity();
        ship.setId(ship.getId());
        ship.setName(ship.getName());
        ship.setType(ship.getType());
        shipRepository.save(ship);
        return ship;
    }

    @Override
    public void deleteShipEntityFromRepository(Long shipId) {
        if (shipId.equals(shipRepository.getById(shipId).getId())) {
            shipRepository.deleteById(shipId);
        } else throw new ResourceNotFoundException("Ship", "id", shipId);
    }

    @Override
    public List<ShipEntity> getAllShip() {
        return shipRepository.findAll();
    }

    @Override
    public ShipEntity updateShipInRepository(Long shipId, ShipEntity shipEntity) throws ResourceNotFoundException {

        ShipEntity ship = shipRepository.findById(shipId)
                .orElseThrow(() -> new ResourceNotFoundException("Ship", "id", shipId));

        ship.setType(shipEntity.getType());
        ship.setName(shipEntity.getName());
        shipRepository.save(ship);
        return ship;
    }
}