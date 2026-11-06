
package com.klef.soa.tourist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.tourist.model.Tourist;
import com.klef.soa.tourist.service.TouristService;

@RestController
@RequestMapping("/tourist")
@CrossOrigin("*")
public class TouristController {

    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    // 1. Insert Tourist
    @PostMapping("/add")
    public ResponseEntity<Tourist> addTourist(
            @RequestBody Tourist tourist) {

        return ResponseEntity.ok(
                touristService.addTourist(tourist));
    }

    // 2. Update Tourist
    @PutMapping("/update/{id}")
    public ResponseEntity<Tourist> updateTourist(
            @PathVariable Long id,
            @RequestBody Tourist tourist) {

        Tourist updated = touristService.updateTourist(id, tourist);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    // 3. Delete Tourist
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTourist(
            @PathVariable Long id) {

        Optional<Tourist> existing =
                touristService.getTouristById(id);

        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        touristService.deleteTourist(id);

        return ResponseEntity.ok("Tourist deleted successfully");
    }

    // 4. Display All Tourists
    @GetMapping("/displayall")
    public ResponseEntity<List<Tourist>> getAllTourists() {

        return ResponseEntity.ok(
                touristService.getAllTourists());
    }

    // 5. Display Tourist By ID
    @GetMapping("/display/{id}")
    public ResponseEntity<Tourist> getTouristById(
            @PathVariable Long id) {

        Optional<Tourist> tourist =
                touristService.getTouristById(id);

        return tourist.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Search Tourist By Name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Tourist>> getTouristByName(
            @PathVariable String name) {

        return ResponseEntity.ok(
                touristService.getTouristByName(name));
    }

    // Search Tourist By Type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Tourist>> getTouristByType(
            @PathVariable String type) {

        return ResponseEntity.ok(
                touristService.getTouristByType(type));
    }
}
