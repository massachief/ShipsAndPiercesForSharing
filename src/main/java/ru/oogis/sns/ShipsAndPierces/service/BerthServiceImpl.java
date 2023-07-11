package ru.oogis.sns.ShipsAndPierces.service;

import org.springframework.stereotype.Service;
import ru.oogis.sns.ShipsAndPierces.data.entity.BerthEntity;
import ru.oogis.sns.ShipsAndPierces.data.repository.BerthRepository;
import ru.oogis.sns.ShipsAndPierces.exeption.ResourceNotFoundException;

@Service
public class BerthServiceImpl implements BerthService {
    BerthRepository berthRepository;
    @Override
    public void printAllBerths() {
        System.out.println(berthRepository);
    }

    @Override
    public void createBerth(BerthEntity berth) {

    }

    @Override
    public void deleteBerthEntityFromRepository(Long shipId) {
        if (berthRepository.getById(Math.toIntExact(shipId)).getId().equals(shipId)) {
            berthRepository.deleteById(Math.toIntExact(shipId));
        } else throw new ResourceNotFoundException("Employee", "id", shipId);
    }

    @Override
    public void editBerthInList() {

    }

    @Override
    public void getListOfBerthInCity() {

    }

    @Override
    public void getAmountShipsInBerth() {

    }

    @Override
    public void getListOfEachShipInCity() {

    }

    @Override
    public void connectShipToBerthByID(Long id) {
    }

    @Override
    public void removeShipFromBerthByID(Long id) {
    }
}
