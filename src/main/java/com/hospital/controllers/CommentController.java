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

    //TODO зробити вивід всіх коментарів за id пацієнта
//    @RequestMapping(value = "/{id}/comments", method = RequestMethod.GET)
//    public List<Comment> getList(@PathVariable long id){
//        return commentService.findByPatientId(id);
//    }

    @RequestMapping(value = "/{id}/comments/{commentId}",method = RequestMethod.GET)
    public Comment getOne(@PathVariable long id){
        return commentService.findOne(id);
    }

    @ResponseStatus(HttpStatus.CREATED )
    @RequestMapping(value = "/{id}/comments", method = RequestMethod.POST)
    public void save(Comment comment) {
        Date currentDate = new Date();
        if(comment.getCreationDate()==null){
            comment.setCreationDate(currentDate);
        }
        commentService.save(comment);
    }

    @RequestMapping(value = "/{id}/comments/{commentId}", method = RequestMethod.PUT)
    public void update(@PathVariable long commentId,Comment comment) {
        comment.setCommentId(commentId);
        commentService.save(comment);
    }

    @RequestMapping(value = "/{id}/comments/{commentId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long commentId) {
        commentService.delete(commentId);
    }

}
