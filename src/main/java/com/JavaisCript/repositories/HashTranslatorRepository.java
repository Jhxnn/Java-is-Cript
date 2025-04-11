package com.JavaisCript.repositories;

import com.JavaisCript.models.HashTranslator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HashTranslatorRepository extends JpaRepository<HashTranslator, UUID> {

    HashTranslator findByKey(String key);
}
