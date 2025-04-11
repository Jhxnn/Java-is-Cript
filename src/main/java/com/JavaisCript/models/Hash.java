package com.JavaisCript.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "hash")
public class Hash {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID hashId;

    private String hash;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id",name = "hashTranslator_id")
    private HashTranslator hashTranslator;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id",name = "user_id")
    private User user;

    private String text;

    private byte[] file;

    public HashTranslator getHashTranslator() {
        return hashTranslator;
    }

    public void setHashTranslator(HashTranslator hashTranslator) {
        this.hashTranslator = hashTranslator;
    }

    public UUID getHashId() {
        return hashId;
    }

    public void setHashId(UUID hashId) {
        this.hashId = hashId;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
