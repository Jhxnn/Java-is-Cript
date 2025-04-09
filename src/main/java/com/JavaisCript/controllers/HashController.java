package com.JavaisCript.controllers;

import com.JavaisCript.dtos.HashDto;
import com.JavaisCript.models.Hash;
import com.JavaisCript.services.HashService;
import jakarta.persistence.Access;
import jakarta.persistence.GeneratedValue;
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

    @GetMapping("/{id}")
    public ResponseEntity<Hash> findById(@PathVariable(name = "id")UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(hashService.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<Hash>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(hashService.findAll());
    }
    @PostMapping
    public ResponseEntity<Hash> createHash(@RequestBody HashDto hashDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(hashService.createHash(hashDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Hash> updateHash(@PathVariable(name = "id")UUID id,
                                           @RequestBody HashDto hashDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(hashService.updateHash(hashDto, id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Hash> deleteHash(@PathVariable(name = "id")UUID id){
        hashService.deleteHash(id);
        return ResponseEntity.noContent().build();
    }
}
