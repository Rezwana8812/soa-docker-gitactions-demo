
package com.klef.soa.tourist;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import com.klef.soa.tourist.model.Tourist;
import com.klef.soa.tourist.repository.TouristRepository;

@DataJpaTest
class TouristRepositoryTest {

    @Autowired
    private TouristRepository touristRepository;

    // 1. Test findAll()
    @Test
    void testFindAll() {
        Tourist tourist = new Tourist();
        tourist.setName("Rahul");
        tourist.setType("Adventure");
        tourist.setStatus("Active");
        tourist.setLocation("Goa");

        touristRepository.save(tourist);

        List<Tourist> result = touristRepository.findAll();

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    // 2. Test findById()
    @Test
    void testFindById() {
        Tourist tourist = new Tourist();
        tourist.setName("Rahul");
        tourist.setType("Adventure");
        tourist.setStatus("Active");
        tourist.setLocation("Goa");

        Tourist saved = touristRepository.save(tourist);

        Optional<Tourist> result =
                touristRepository.findById(saved.getTouristId());

        assertTrue(result.isPresent());
        assertEquals("Rahul", result.get().getName());

        Optional<Tourist> missing =
                touristRepository.findById(-1L);

        assertFalse(missing.isPresent());
    }

    // 3. Test derived query methods
    @Test
    void testDerivedQueries() {
        Tourist tourist = new Tourist();
        tourist.setName("Rahul");
        tourist.setType("Adventure");
        tourist.setStatus("Active");
        tourist.setLocation("Goa");

        touristRepository.save(tourist);

        List<Tourist> nameResult =
                touristRepository.findByName("Rahul");

        List<Tourist> typeResult =
                touristRepository.findByType("Adventure");

        assertFalse(nameResult.isEmpty());
        assertFalse(typeResult.isEmpty());
    }

    // 4. Test count()
    @Test
    void testCount() {
        Tourist tourist = new Tourist();
        tourist.setName("Priya");
        tourist.setType("Nature");
        tourist.setStatus("Active");
        tourist.setLocation("Kerala");

        touristRepository.save(tourist);

        long count = touristRepository.count();

        assertEquals(1L, count);
    }

    // 5. Test tourist details
    @Test
    void testTouristDetails() {
        Tourist tourist = new Tourist();
        tourist.setName("Priya");
        tourist.setType("Nature");
        tourist.setStatus("Active");
        tourist.setLocation("Kerala");

        Tourist saved = touristRepository.save(tourist);

        assertNotNull(saved.getTouristId());
        assertEquals("Priya", saved.getName());
        assertEquals("Nature", saved.getType());
        assertEquals("Active", saved.getStatus());
        assertEquals("Kerala", saved.getLocation());
        assertNotNull(saved.getCreatedAt());
        assertNotNull(saved.getUpdatedAt());
    }
}
