package com.devsession.conferencedemoapi.controllers;

import com.devsession.conferencedemoapi.models.Speaker;
import com.devsession.conferencedemoapi.repositories.SpeakerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/", produces = "application/json")
    @ApiOperation("Returns a list of speakers.")
    public List<Speaker> getAllSpeakers(){
        return speakerRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
    @ApiOperation("Returns a single speaker.")
    public Speaker getSpeakerById(@PathVariable  Long id){
        return speakerRepository.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ApiOperation("Creates a speaker entity")
    public Speaker createSpeaker(@RequestBody final Speaker speaker){
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}", produces = "application/json")
    @ApiOperation("Deletes a speaker")
    public void deleteSpeaker(@PathVariable Long id){

        speakerRepository.deleteById(id);

    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    @ApiOperation("Updates a speaker entity")
    public Speaker updateSpeaker(@PathVariable Long id, @RequestBody Speaker speaker){
        Speaker existingSpeaker = speakerRepository.getById(id);
        BeanUtils.copyProperties(speaker,existingSpeaker,"speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);

    }


}
