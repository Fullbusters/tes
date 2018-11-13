package historicalsight.controllers;

import com.historicalsight.models.City;
import com.historicalsight.models.Region;
import com.historicalsight.services.CityService;
import com.historicalsight.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @Autowired
    private CityService cityService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public List<Region> getAll(){
        return regionService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}",method =RequestMethod.GET)
    public Region getById(@PathVariable long id){
        return regionService.findOne(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id){
        regionService.delete(id);
    }

    @CrossOrigin
    @RequestMapping( method = RequestMethod.POST)
    public void save(@RequestBody Region region){
        regionService.save(region);
    }

    @CrossOrigin
    @RequestMapping( method = RequestMethod.PUT)
    public void update(@RequestBody Region region){
        regionService.save(region);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}/city",method =RequestMethod.GET)
    public List<City> getAllCItyByRegionId(@PathVariable long id){
        return cityService.findCitysByRegionId(id);
    }
}
