package ru.oogis.sns.ships.data.entity;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table
@Entity
public class BerthEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String locationCity;
    @OneToMany
    private List<ShipEntity> shipEntityArrayList;

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

    public void addShip(ShipEntity shipEntity) {
        shipEntityArrayList.add(shipEntity);
    }

    @Override
    public String toString() {
        return "BerthEntity{" + "id=" + id + ", locationCity=" + locationCity + '\'' + ", Ships in Berth=" + shipEntityArrayList + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, locationCity, shipEntityArrayList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BerthEntity berth = (BerthEntity) o;
        return Double.compare(berth.id, id) == 0 && Objects.equals(id, berth.id) &&
                Objects.equals(locationCity, berth.locationCity) &&
                Objects.equals(shipEntityArrayList, berth.shipEntityArrayList);
    }
}
