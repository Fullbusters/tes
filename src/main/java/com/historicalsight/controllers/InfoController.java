package com.historicalsight.controllers;

import com.historicalsight.models.Info;
import com.historicalsight.services.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public List<Info> getAll(){
        return infoService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Info getOne(@PathVariable long id){
        return infoService.getOne(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id){
        infoService.delete(id);
    }

    @CrossOrigin
    @RequestMapping( method = RequestMethod.POST)
    public void save(@RequestBody Info info){
        infoService.save(info);
    }
    @CrossOrigin
    @RequestMapping( method = RequestMethod.PUT)
    public void update(@RequestBody Info info){
        infoService.save(info);
    }
}
