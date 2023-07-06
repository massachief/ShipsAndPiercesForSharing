package ru.oogis.sns.ShipsAndPierces.data.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Objects;

public class BerthEntity {
    private @Id
    @GeneratedValue Long id;
    public String locationCity;
    public List<ShipEntity> shipEntityArrayList;

    public BerthEntity() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public void setShipEntityArrayList(List<ShipEntity> shipEntityArrayList) {
        this.shipEntityArrayList = shipEntityArrayList;
    }

    public Long getId() {
        return this.id;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public List<ShipEntity> getShipEntityArrayList() {
        return shipEntityArrayList;
    }

    @Override
    public String toString() {
        return "BerthEntity{" + "id=" + id + ", locationCity=" + locationCity + '\'' + ", Ships in Berth=" + shipEntityArrayList + '}';
    }
    @Override
    public int hashCode(){
        return Objects.hash(id, locationCity, shipEntityArrayList);
    }
}
