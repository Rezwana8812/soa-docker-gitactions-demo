
package com.klef.soa.tourist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.klef.soa.tourist.model.Tourist;
import com.klef.soa.tourist.repository.TouristRepository;

@Service
public class TouristService {

    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    // Insert Tourist
    public Tourist addTourist(Tourist tourist) {
        return touristRepository.save(tourist);
    }

    // Update Tourist
    public Tourist updateTourist(Long id, Tourist tourist) {
        Optional<Tourist> existing =
                touristRepository.findById(id);

        if (existing.isPresent()) {
            Tourist t = existing.get();

            t.setName(tourist.getName());
            t.setType(tourist.getType());
            t.setStatus(tourist.getStatus());
            t.setLocation(tourist.getLocation());

            return touristRepository.save(t);
        }

        return null;
    }

    // Delete Tourist
    public void deleteTourist(Long id) {
        touristRepository.deleteById(id);
    }

    // Display All Tourists
    public List<Tourist> getAllTourists() {
        return touristRepository.findAll();
    }

    // Display Tourist By ID
    public Optional<Tourist> getTouristById(Long id) {
        return touristRepository.findById(id);
    }

    // Find By Name
    public List<Tourist> getTouristByName(String name) {
        return touristRepository.findByName(name);
    }

    // Find By Type
    public List<Tourist> getTouristByType(String type) {
        return touristRepository.findByType(type);
    }
}
