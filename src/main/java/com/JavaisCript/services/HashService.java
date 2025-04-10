package com.JavaisCript.services;


import com.JavaisCript.dtos.HashDto;
import com.JavaisCript.models.Hash;
import com.JavaisCript.repositories.HashRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
        String[] hashList = hashDto.hash().split("");

        for(int i = 0; i > hashList.length; i++){

        }
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
    public List<String> alphList(String[] hash){
        List<String> alph = new ArrayList<>(
                Arrays.asList("a","b","c","d","e","f","g","h","i","j","k",
                        "l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"));

        for(int i = 0; i < hash.length; i++){
            for(int x = 0; x < 23; x ++){

            }
        }



    }


}
