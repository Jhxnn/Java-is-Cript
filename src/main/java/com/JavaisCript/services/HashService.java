package com.JavaisCript.services;


import com.JavaisCript.dtos.HashDto;
import com.JavaisCript.models.Hash;
import com.JavaisCript.repositories.HashRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HashService {

    @Autowired
    HashRepository hashRepository;

    public Hash findById(UUID id){
        return hashRepository.findById(id).orElseThrow(()-> new RuntimeException("Cannot be found"));
    }
    public List<Hash> findAll(){
        return hashRepository.findAll();
    }
    public Hash createHash(HashDto hashDto){
        var hash = new Hash();
        BeanUtils.copyProperties(hashDto,hash);
        return hashRepository.save(hash);
    }
    public Hash updateHash(HashDto hashDto, UUID id){
        var hash = findById(id);
        BeanUtils.copyProperties(hashDto,hash);
        return hashRepository.save(hash);
    }
    public void deleteHash(UUID id){
        var hash = findById(id);
        hashRepository.delete(hash);

    }

}
