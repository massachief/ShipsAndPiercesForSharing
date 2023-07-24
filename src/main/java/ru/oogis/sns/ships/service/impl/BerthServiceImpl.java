package ru.oogis.sns.ships.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.oogis.sns.ships.data.entity.BerthEntity;
import ru.oogis.sns.ships.data.entity.ShipEntity;
import ru.oogis.sns.ships.data.repository.BerthRepository;
import ru.oogis.sns.ships.data.repository.ShipRepository;
import ru.oogis.sns.ships.exeption.ResourceNotFoundException;
import ru.oogis.sns.ships.service.BerthService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BerthServiceImpl implements BerthService {

    BerthServiceImpl(BerthRepository berthRepository, ShipRepository shipRepository) {
        this.berthRepository = berthRepository;
        this.shipRepository = shipRepository;
    }

    @Autowired
    private final BerthRepository berthRepository;
    @Autowired
    private final ShipRepository shipRepository;

    @Override
    public List<BerthEntity> getAllBerth() {
        return berthRepository.findAll();
    }

    @Override
    public BerthEntity createBerth(BerthEntity berthEntity) {
        BerthEntity berth = new BerthEntity();
        berth.setId(berth.getId());
        berth.setLocationCity(berth.getLocationCity());
        berth.setShipEntityArrayList(berth.getShipEntityArrayList());

        return berthRepository.save(berth);
    }

    @Override
    public void deleteBerthEntityFromRepository(Long berthId) {
        if (berthRepository.getById(berthId).getId().equals(berthId)) {
            berthRepository.deleteById(berthId);
        } else throw new ResourceNotFoundException("Ship", "id", berthId);
    }

    @Override
    public BerthEntity updateBerthEntity(Long berthId, BerthEntity berthEntity) {
        BerthEntity berth = berthRepository.findById(berthId)
                .orElseThrow(() -> new ResourceNotFoundException("Berth", "id", berthId));

        berth.setShipEntityArrayList(berthEntity.getShipEntityArrayList());
        berth.setLocationCity(berthEntity.getLocationCity());
        berthRepository.save(berth);
        return berth;
    }


    @Override
    public int getAmountShipsInBerth(BerthEntity berth) {
        return berth.getShipEntityArrayList().size();
    }

    public BerthEntity getBerthById(Long berthId) throws ResourceNotFoundException {
        return berthRepository.findById(berthId)
                .orElseThrow(() -> new ResourceNotFoundException("Berth", "id", berthId));
    }

    @Override
    public List<BerthEntity> getListOfBerthInCity(String location) {
        if (location == null || location.isEmpty())
            return Collections.emptyList();
        return berthRepository.findAll().stream()
                .filter(berthEntity -> location.equals(berthEntity.getLocationCity()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipEntity> getListOfEachShipInCity(String location) {
        if (location == null || location.isEmpty())
            return Collections.emptyList();
        return berthRepository.findAll().stream()
                .filter(berthEntity -> location.equals(berthEntity.getLocationCity()))
                .map(BerthEntity::getShipEntityArrayList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }


    @Override
    public void connectShipToBerthByID(Long shipId, Long berthId) {
        berthRepository.getById(berthId).
                addShip(shipRepository.getById(berthId));
    }

    @Override
    public void removeShipFromBerthByID(Long shipId, Long berthId) {
        berthRepository.getById(berthId)
                .getShipEntityArrayList().remove(shipRepository.getById(shipId));
    }

}
