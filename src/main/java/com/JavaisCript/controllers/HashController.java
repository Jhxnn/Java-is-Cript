package com.JavaisCript.controllers;

import com.JavaisCript.services.HashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hash")
public class HashController {

    @Autowired
    HashService hashService;



}
