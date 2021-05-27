package com.devsession.conferencedemoapi.controllers;


import com.devsession.conferencedemoapi.models.Session;
import com.devsession.conferencedemoapi.repositories.SessionRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    @Autowired
    private SessionRepository sessionRepository;


    @RequestMapping(method = RequestMethod.GET, path = "/", produces = "application/json")
    @ApiOperation("Returns a complete list of sessions.")
    public List<Session> list(){
        return sessionRepository.findAll();

    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
    @ApiOperation("Returns a single session.")
    public Session getSessionById(@PathVariable Long id){
        return sessionRepository.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ApiOperation("Creates a session entity.")
    @ResponseStatus(value= HttpStatus.CREATED)
    public Session createSession(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ApiOperation("Deletes a person from the system. 404 if the person's identifier is not found.")
    public void deleteSession(@PathVariable Long id){
        sessionRepository.deleteById(id);
    }


    @RequestMapping(method = RequestMethod.PUT, path = "/{id}", produces = "application/json")
    @ApiOperation("Updates a session entity")
    public Session updateSession(@PathVariable Long id, @RequestBody Session session){
        //TODO:  add missing validation
        Session existingSession = sessionRepository.getById(id);
        BeanUtils.copyProperties(session,existingSession,"session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }
}
