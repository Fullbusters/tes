package historicalsight.controllers;

import com.historicalsight.models.HistoricalSight;
import com.historicalsight.services.HistoricalSightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historicalsight")
public class HistoricalSightController {

    @Autowired
    private HistoricalSightService historicalSightService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public List<HistoricalSight> getAll(){
        return historicalSightService.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public HistoricalSight getOne(@PathVariable long id){
        return historicalSightService.findOne(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id){
        historicalSightService.delete(id);
    }

    @CrossOrigin
    @RequestMapping( method = RequestMethod.POST)
    public void save(@RequestBody HistoricalSight historicalSight){
        historicalSightService.save(historicalSight);
    }
    @CrossOrigin
    @RequestMapping( method = RequestMethod.PUT)
    public void update(@RequestBody HistoricalSight historicalSight){
        historicalSightService.save(historicalSight);
    }
}
