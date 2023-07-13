package ru.oogis.sns.ShipsAndPierces.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.oogis.sns.ShipsAndPierces.data.entity.BerthEntity;
import ru.oogis.sns.ShipsAndPierces.data.repository.BerthRepository;
import ru.oogis.sns.ShipsAndPierces.data.repository.ShipRepository;
import ru.oogis.sns.ShipsAndPierces.exeption.ResourceNotFoundException;
import ru.oogis.sns.ShipsAndPierces.service.BerthService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BerthServiceImpl implements BerthService {
    @Autowired
    BerthRepository berthRepository;
    ShipRepository shipRepository;

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
        } else throw new ResourceNotFoundException("Employee", "id", berthId);
    }

    @Override
    public Optional<BerthEntity> updateBerthEntity(Long berthId, BerthEntity berthEntity) {
        Optional<BerthEntity> berth = berthRepository.findById(berthId);
        if (berth.isEmpty())
            throw new ResourceNotFoundException("Ship", "id", berthId);

        berth.get().setShipEntityArrayList(berthEntity.getShipEntityArrayList());
        berth.get().setLocationCity(berthEntity.getLocationCity());
        berthRepository.save(berth.get());

        return berth;

    }


    @Override
    public int getAmountShipsInBerth(BerthEntity berth) {
        return berth.getShipEntityArrayList().size();
    }

    public BerthEntity getBerthById(Long berthId) throws ResourceNotFoundException {
        return berthRepository.findById(berthId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", berthId));
    }

    @Override
    public List<BerthEntity> getListOfBerthInCity(String location) {
        List<BerthEntity> entityList = berthRepository.findAll();
        List<BerthEntity> returnList = new ArrayList<>();
        for (BerthEntity berthEntity : entityList) {
            if (Objects.equals(berthEntity.locationCity.toLowerCase(), location.toLowerCase())) {
                returnList.add(berthEntity);
            }
        }
        return returnList;
    }

    @Override
    public List<BerthEntity> getListOfEachShipInCity(String location) {
        List<BerthEntity> entityList = berthRepository.findAll();
        List<BerthEntity> returnList = new ArrayList<>();
        for (BerthEntity berthEntity : entityList) {
            {
                if (Objects.equals(berthEntity.locationCity, location)) {
                    returnList.add((BerthEntity) berthEntity.shipEntityArrayList);
                }
            }
        }
        return returnList;
    }


    @Override
    public void connectShipToBerthByID(Long shipId, Long berthId) {
        berthRepository.findById(berthId).get().
                addShip(shipRepository.getReferenceById(shipId));
    }

    @Override
    public void removeShipFromBerthByID(Long shipId, Long berthId) {
        berthRepository.findById(berthId).get()
                .shipEntityArrayList.remove(shipRepository.getReferenceById(shipId));
    }
}
