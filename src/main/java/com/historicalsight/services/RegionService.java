package com.historicalsight.services;

import com.historicalsight.models.Region;
import com.historicalsight.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<Region> getAll(){
        return regionRepository.findAll();
    }

    public Region findOne(Long id){
        return regionRepository.findOne(id);
    }

    public Region save(Region region){
        return regionRepository.save(region);
    }

    public void delete(Long id){
        regionRepository.delete(id);
    }

}
