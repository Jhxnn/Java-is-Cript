package com.JavaisCript.dtos;

import java.util.UUID;

public record HashDto(String hash, UUID userId, String text, byte[] file) {
}
