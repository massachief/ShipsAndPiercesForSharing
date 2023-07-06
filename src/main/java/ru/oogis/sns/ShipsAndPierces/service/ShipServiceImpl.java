package ru.oogis.sns.ShipsAndPierces.service;

import org.springframework.stereotype.Service;
import ru.oogis.sns.ShipsAndPierces.data.entity.ShipEntity;
import ru.oogis.sns.ShipsAndPierces.data.repository.ShipRepository;

import java.util.List;

@Service
public class ShipServiceImpl implements ShipService {
    ShipRepository shipRepository;
    private static final List<ShipEntity> shipEntityList = null;

    @Override
    public void addShipToList(ShipEntity shipEntity) {
        shipEntityList.add(shipEntity);
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
    public boolean removeShipFromList(ShipEntity shipEntity) {
        return shipEntityList.remove(shipEntity);
    }

    @Override
    public void printAllShips() {
        System.out.println(shipEntityList);
    }

    @Override
    public boolean updateShipInList(ShipEntity shipEntity) {
        return false;
    }


}