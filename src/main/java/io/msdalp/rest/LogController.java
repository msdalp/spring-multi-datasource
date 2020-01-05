package io.msdalp.rest;

import io.msdalp.dstwo.Log;
import io.msdalp.dstwo.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    private final LogRepository logRepository;


    @Autowired
    public LogController(LogRepository logRepository) {
        this.logRepository = logRepository;
    }
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Log> getLogs() {
        return logRepository.findAll();
    }
}
