package com.hospital.controllers;

import com.hospital.models.Comment;
import com.hospital.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

// URL виходить такий же самий як і у PatientController
// але робити їх в 1 контролері буде більш не правильно
@RestController
@RequestMapping("/patients")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @CrossOrigin
    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public List<Comment> getAll(){
        return commentService.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}/comments", method = RequestMethod.GET)
    public List<Comment> getList(@PathVariable long id){
        return commentService.findByPatientPatientId(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}/comments/{commentId}",method = RequestMethod.GET)
    public Comment getOne(@PathVariable long commentId){
        return commentService.findOne(commentId);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED )
    @RequestMapping(value = "/{id}/comments", method = RequestMethod.POST)
    public void save(@RequestBody Comment comment) {
        Date currentDate = new Date();
        if(comment.getCreationDate()==null){
            comment.setCreationDate(currentDate);
        }
        commentService.save(comment);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}/comments", method = RequestMethod.PUT)
    public void update(@RequestBody Comment comment) {
        commentService.save(comment);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}/comments/{commentId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long commentId) {
        commentService.delete(commentId);
    }

}
