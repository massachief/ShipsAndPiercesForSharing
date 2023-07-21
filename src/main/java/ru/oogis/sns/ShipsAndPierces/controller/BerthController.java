package ru.oogis.sns.ShipsAndPierces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.oogis.sns.ShipsAndPierces.data.entity.BerthEntity;
import ru.oogis.sns.ShipsAndPierces.exeption.ResourceNotFoundException;
import ru.oogis.sns.ShipsAndPierces.service.BerthService;

import java.util.List;

@RestController
@RequestMapping("/berths")
public class BerthController {
    private final BerthService berthService;

    public BerthController(BerthService berthService) {
        this.berthService = berthService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BerthEntity>> getAllBerths() {
        List<BerthEntity> berths = berthService.getAllBerth();
        return new ResponseEntity<>(berths, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<BerthEntity> addBerth(@RequestBody BerthEntity berthEntity) {
        BerthEntity newBerth = berthService.createBerth(berthEntity);
        return new ResponseEntity<>(newBerth, HttpStatus.CREATED);
    }

    @PutMapping("/update/{berthId}")
    public ResponseEntity<BerthEntity> updateBerth(@PathVariable Long berthId, @RequestBody BerthEntity berthEntity) {
        BerthEntity updateBerth = berthService.updateBerthEntity(berthId, berthEntity).
                orElseThrow(() -> new ResourceNotFoundException("Berth", "id", berthId));
        return new ResponseEntity<>(updateBerth, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{berthId}")
    public ResponseEntity<?> deleteBerth(@PathVariable("id") Long shipId) {
        berthService.deleteBerthEntityFromRepository(shipId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
