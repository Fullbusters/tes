package com.hospital.controllers;


import com.hospital.models.Patient;
import com.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping
    public List<Patient> getList(){
        return patientService.findAll();
    }

    @RequestMapping(value = "/{id}",method =RequestMethod.GET)
    public Patient getById(@PathVariable long id){
        return patientService.findOne(id);
    }

    @ResponseStatus(HttpStatus.CREATED )
    @RequestMapping(method = RequestMethod.POST)
    public void save(Patient patient) {
        patientService.save(patient);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(Patient patient) {
        patientService.save(patient);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        patientService.delete(id);
    }

}