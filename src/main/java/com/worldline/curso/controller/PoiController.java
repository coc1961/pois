package com.worldline.curso.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.worldline.curso.services.PoiService;

/**
 * REST API of Share Data Manager service
 * 
 * @author a548275
 *
 */
@RestController
@RequestMapping("/v1/poiservice")
public class PoiController
{

    protected static final Logger logger = LoggerFactory.getLogger(PoiController.class);

    @Autowired
    PoiService poiService;
    
    @RequestMapping(value="/findPoiByService/{serviceName}",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<String> findPoiByServices(@PathVariable("serviceName") String serviceName) {

        return new  ResponseEntity<String>("Ok", HttpStatus.OK);
    }

}
