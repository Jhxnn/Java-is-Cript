package com.JavaisCript.services;


import com.JavaisCript.dtos.HashDto;
import com.JavaisCript.models.Hash;
import com.JavaisCript.models.HashTranslator;
import com.JavaisCript.repositories.HashRepository;
import com.JavaisCript.repositories.HashTranslatorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HashService {

    @Autowired
    HashRepository hashRepository;

    @Autowired
    HashTranslatorRepository hashTranslatorRepository;

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

        for(int i = 0; i < 24; i++){
            Random random = new Random();

        }
    }


}
