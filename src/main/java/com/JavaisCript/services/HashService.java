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
        HashTranslator hashT = alphList(hashDto.hash());
        BeanUtils.copyProperties(hashDto,hash);
        hash.setHashTranslator(hashT);
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
    public HashTranslator alphList(String hash){
        List<String> alph = new ArrayList<>(
                Arrays.asList("a","b","c","d","e","f","g","h","i","j","k",
                        "l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"));

        List<String> alphReplace = new ArrayList<>();

        for(int i = 26; i > 1; i--){
            Random random = new Random();
            int randomNumber = random.nextInt(i);
            String letter = alph.get(randomNumber);
            alph.remove(randomNumber);
            alphReplace.add(letter);

        }
        HashTranslator hashT = new HashTranslator(alphReplace.get(0),alphReplace.get(1),alphReplace.get(2),alphReplace.get(3),
                alphReplace.get(4),alphReplace.get(5),alphReplace.get(6),alphReplace.get(7),alphReplace.get(8),alphReplace.get(9),
                alphReplace.get(10),alphReplace.get(11),alphReplace.get(12),alphReplace.get(13),alphReplace.get(14),alphReplace.get(15),
                alphReplace.get(16),alphReplace.get(17),alphReplace.get(18),alphReplace.get(19),alphReplace.get(20),alphReplace.get(21),
                alphReplace.get(22),alphReplace.get(23),alphReplace.get(24),alphReplace.get(25), hash);

        return hashTranslatorRepository.save(hashT);
    }


}
