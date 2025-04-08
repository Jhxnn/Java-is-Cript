package com.JavaisCript.repositories;

import com.JavaisCript.models.Hash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HashRepository extends JpaRepository<Hash, UUID> {
}
