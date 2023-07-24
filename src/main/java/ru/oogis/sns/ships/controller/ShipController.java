package ru.oogis.sns.ships.controller;

import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.oogis.sns.ships.data.entity.ShipEntity;
import ru.oogis.sns.ships.service.ShipService;

import java.util.List;

@RestController
@RequestMapping("/ships")
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message =
                "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message =
                "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message =
                "The server is down. Please bear with us."),
}
)
public class ShipController {
    @Autowired
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
        return ResponseEntity.ok(shipService.updateShipInRepository(shipId, shipEntity));
    }

    @DeleteMapping("/delete/{shipId}")
    public ResponseEntity<?> deleteShip(@PathVariable("id") Long shipId) {
        shipService.deleteShipEntityFromRepository(shipId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
