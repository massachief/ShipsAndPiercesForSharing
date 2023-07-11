package ru.oogis.sns.ShipsAndPierces.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.oogis.sns.ShipsAndPierces.data.entity.ShipEntity;
import ru.oogis.sns.ShipsAndPierces.data.repository.ShipRepository;
import ru.oogis.sns.ShipsAndPierces.exeption.ResourceNotFoundException;

import java.util.Optional;

@Service
public class ShipServiceImpl implements ShipService {
    @Autowired
    ShipRepository shipRepository;

    @Override
    public void addShipToList(ShipEntity shipEntity) {
        shipRepository.save(shipEntity);
    }

    @Override
    public String createShip(ShipEntity shipEntity) {
        ShipEntity ship = new ShipEntity();
        ship.setId(ship.getId());
        ship.setName(ship.getName());
        ship.setType(ship.getType());
        shipRepository.save(ship);
        return "New Ship created successfully";
    }

    @Override
    public void deleteShipEntityFromRepository(Long shipId) {
        if (shipRepository.getById(Math.toIntExact(shipId)).getId().equals(shipId)) {
            shipRepository.deleteById(Math.toIntExact(shipId));
        } else throw new ResourceNotFoundException("Employee", "id", shipId);
    }

    @Override
    public void printAllShips() {
        System.out.println(shipRepository);
    }

    @Override
    public Optional<ShipEntity> updateShipInList(Long shipId, ShipEntity shipEntity) throws ResourceNotFoundException {
        Optional<ShipEntity> ship = shipRepository.findById(Math.toIntExact(shipId));
        if (ship.isEmpty()) {
            throw new ResourceNotFoundException("Ship", "id", shipId);
        } else
            ship.get().setType(shipEntity.getType());
        ship.get().setName(shipEntity.getName());
        shipRepository.save(ship.get());
        return ship;
    }


}