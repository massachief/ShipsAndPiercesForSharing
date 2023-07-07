package ru.oogis.sns.ShipsAndPierces.service;

import org.springframework.stereotype.Service;
import ru.oogis.sns.ShipsAndPierces.data.entity.BerthEntity;

import java.util.HashMap;
import java.util.Map;

@Service
public class BerthServiceImpl implements BerthService {
    private static Map<Long, BerthEntity> BERTH_REPOSITORY_MAP = new HashMap<>();

    public static void setMap(Map<Long, BerthEntity> map){
        if (map == null)
            throw new RuntimeException();
        BERTH_REPOSITORY_MAP = map;
    }

    @Override
    public void printAllBerths() {
        System.out.println(BERTH_REPOSITORY_MAP.values());
    }

    @Override
    public void addBertToList(BerthEntity berth) {

        BERTH_REPOSITORY_MAP.put(berth.getId(), berth);
    }

    @Override
    public void removeBerthFromList(Long id) {
        BERTH_REPOSITORY_MAP.remove(id);
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
