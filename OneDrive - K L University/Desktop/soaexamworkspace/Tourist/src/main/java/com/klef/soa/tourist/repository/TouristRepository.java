
package com.klef.soa.tourist.repository;

import com.klef.soa.tourist.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TouristRepository
        extends JpaRepository<Tourist, Long> {

    List<Tourist> findByName(String name);

    List<Tourist> findByType(String type);
}
