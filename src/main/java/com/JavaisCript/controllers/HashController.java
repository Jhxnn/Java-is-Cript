package com.JavaisCript.controllers;

import com.JavaisCript.dtos.HashTranslatorDto;
import com.JavaisCript.models.HashTranslator;
import com.JavaisCript.services.HashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hash")
public class HashController {

    @Autowired
    HashService hashService;


    @PostMapping("/createManually")
    public ResponseEntity<HashTranslator> createHashManually(HashTranslatorDto hashTranslatorDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(hashService.createHashManually(hashTranslatorDto));
    }
    @PostMapping("/create/{hash}")
    public ResponseEntity<HashTranslator> createHash(@PathVariable(name = "hash")String hash){
        return ResponseEntity.status(HttpStatus.CREATED).body(hashService.createHash(hash));
    }
    @PostMapping("/file")
    public ResponseEntity<byte[]> createFile(@RequestParam("file")MultipartFile file,
                                             @RequestParam("key")String key) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(hashService.returnFileCript(file, key));
    }




}
