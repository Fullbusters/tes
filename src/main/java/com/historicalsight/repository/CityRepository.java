package com.historicalsight.repository;

import com.historicalsight.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository  extends JpaRepository<City, Long> {
    @Query(value = "SELECT * FROM city  WHERE Region_id=?1", nativeQuery = true)
    List<City> findByRegionId(Long id);
}
