package com.historicalsight.services;


import com.historicalsight.models.City;
import com.historicalsight.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAll(){
       return cityRepository.findAll();
    }

    public City getOne(Long id){
        return cityRepository.getOne(id);
    }

    public City save(City city){
        return cityRepository.save(city);
    }

    public void delete(Long id){
        cityRepository.delete(id);
    }

    public List<City> findCitysByRegionId(Long id) {
        return cityRepository.findByRegionId(id);
    }
}
