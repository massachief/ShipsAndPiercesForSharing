package ru.oogis.sns.ShipsAndPierces.data.entity;

import javax.persistence.*;
import java.util.Objects;
@Entity
public class ShipEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ShipType type;

    public ShipEntity() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(ShipType type) {
        this.type = type;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public ShipType getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "ShipEntity{" + "id=" + id + ", name='" + name + '\'' +
                ", type=" + type + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipEntity ship = (ShipEntity) o;
        return Double.compare(ship.id, id) == 0 && Objects.equals(id, ship.id) && Objects.equals(name, ship.name) && Objects.equals(type, ship.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type);
    }
}
