package com.JavaisCript.services;


import com.JavaisCript.dtos.HashTranslatorDto;
import com.JavaisCript.models.HashTranslator;
import com.JavaisCript.repositories.HashTranslatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class HashService {

    @Autowired
    HashTranslatorRepository hashTranslatorRepository;


    public HashTranslator createHashManually(HashTranslatorDto hashTranslatorDto){
        HashTranslator hashT = new HashTranslator(hashTranslatorDto.a(),hashTranslatorDto.b(),hashTranslatorDto.c(),
                hashTranslatorDto.d(),hashTranslatorDto.e(),hashTranslatorDto.f(),hashTranslatorDto.g(),hashTranslatorDto.h(),
                hashTranslatorDto.i(),hashTranslatorDto.j(), hashTranslatorDto.k(),hashTranslatorDto.l(),hashTranslatorDto.m(),
                hashTranslatorDto.n(),hashTranslatorDto.o(),hashTranslatorDto.p(),hashTranslatorDto.q(),hashTranslatorDto.r(),
                hashTranslatorDto.s(),hashTranslatorDto.t(),hashTranslatorDto.u(),hashTranslatorDto.v(),hashTranslatorDto.w(),
                hashTranslatorDto.x(),hashTranslatorDto.y(),hashTranslatorDto.z(),hashTranslatorDto.key());
        return hashTranslatorRepository.save(hashT);
    }

    public byte[] returnFileCript(MultipartFile file, String key) throws IOException {
        HashTranslator hash = hashTranslatorRepository.findByKey(key);
        String conteudo = new String(file.getBytes(), StandardCharsets.UTF_8);
        conteudo.replace("a", hash.getaIs())
                .replace("b", hash.getbIs())
                .replace("c", hash.getcIs())
                .replace("d", hash.getdIs())
                .replace("e", hash.geteIs())
                .replace("f", hash.getfIs())
                .replace("g", hash.getgIs())
                .replace("h", hash.gethIs())
                .replace("i", hash.getiIs())
                .replace("j", hash.getjIs())
                .replace("k", hash.getkIs())
                .replace("l", hash.getlIs())
                .replace("m", hash.getmIs())
                .replace("n", hash.getnIs())
                .replace("o", hash.getoIs())
                .replace("p", hash.getpIs())
                .replace("q", hash.getqIs())
                .replace("r", hash.getrIs())
                .replace("s", hash.getsIs())
                .replace("t", hash.gettIs())
                .replace("u", hash.getuIs())
                .replace("v", hash.getvIs())
                .replace("w", hash.getwIs())
                .replace("x", hash.getxIs())
                .replace("y", hash.getyIs())
                .replace("z", hash.getzIs());

        Path caminho = Paths.get("criptografado.txt");
        Files.write(caminho, conteudo.getBytes(StandardCharsets.UTF_8));
        return Files.readAllBytes(caminho);

    }

    public HashTranslator createHash(String hash){
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
