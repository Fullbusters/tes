package com.historicalsight.controllers;


import com.historicalsight.models.City;
import com.historicalsight.models.HistoricalSight;
import com.historicalsight.services.CityService;
import com.historicalsight.services.HistoricalSightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private HistoricalSightService historicalSightService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public List<City> getAll(){
        return cityService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public City getOne(@PathVariable long id){
        return cityService.getOne(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}/com.historicalsight",method = RequestMethod.GET)
    public List<HistoricalSight> getHistoricalSightByCityId(@PathVariable long id){
        return historicalSightService.getHistoricalSight(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id){
        cityService.delete(id);
    }

    @CrossOrigin
    @RequestMapping( method = RequestMethod.POST)
    public void save(@RequestBody City city){
        cityService.save(city);
    }
    @CrossOrigin
    @RequestMapping( method = RequestMethod.PUT)
    public void update(@RequestBody City city){
        cityService.save(city);
    }
}
