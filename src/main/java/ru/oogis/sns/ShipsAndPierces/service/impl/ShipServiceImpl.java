package ru.oogis.sns.ShipsAndPierces.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.oogis.sns.ShipsAndPierces.data.entity.ShipEntity;
import ru.oogis.sns.ShipsAndPierces.data.repository.ShipRepository;
import ru.oogis.sns.ShipsAndPierces.exeption.ResourceNotFoundException;
import ru.oogis.sns.ShipsAndPierces.service.ShipService;

import java.util.List;
import java.util.Optional;

@Service
public class ShipServiceImpl implements ShipService {
    @Autowired
    ShipRepository shipRepository;

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
        if (shipRepository.getById(shipId).getId().equals(shipId)) {
            shipRepository.deleteById(shipId);
        } else throw new ResourceNotFoundException("Employee", "id", shipId);
    }

    @Override
    public List<ShipEntity> getAllShip() {
        return shipRepository.findAll();
    }

    @Override
    public Optional<ShipEntity> updateShipInRepository(Long shipId, ShipEntity shipEntity) throws ResourceNotFoundException {
        Optional<ShipEntity> ship = shipRepository.findById(shipId);
        if (ship.isEmpty()) {
            throw new ResourceNotFoundException("Ship", "id", shipId);
        } else
            ship.get().setType(shipEntity.getType());
        ship.get().setName(shipEntity.getName());
        shipRepository.save(ship.get());
        return ship;
    }


}