package ru.oogis.sns.ShipsAndPierces.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.oogis.sns.ShipsAndPierces.data.entity.ShipEntity;
import ru.oogis.sns.ShipsAndPierces.service.ShipService;

import java.util.List;

@RestController
@RequestMapping("/Ship")
public class ShipController {
    private final ShipService shipService;

    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ShipEntity>> getAllShips() {
        List<ShipEntity> ships = shipService.getAllShip();
        return new ResponseEntity<>(ships, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ShipEntity> addShip(@RequestBody ShipEntity shipEntity) {
        ShipEntity newShip = shipService.createShip(shipEntity);
        return new ResponseEntity<>(newShip, HttpStatus.CREATED);
    }

    @PutMapping("/update/{shipId}")
    public ResponseEntity<ShipEntity> updateShip(@PathVariable Long shipId, @RequestBody ShipEntity shipEntity) {
        ShipEntity updateShip = shipService.updateShipInRepository(shipId, shipEntity).get();
        return new ResponseEntity<>(updateShip, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{shipId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long shipId) {
        shipService.deleteShipEntityFromRepository(shipId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
