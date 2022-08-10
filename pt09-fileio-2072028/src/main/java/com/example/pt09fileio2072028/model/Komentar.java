package com.example.pt09fileio2072028.model;

public class Komentar {
    public String username;
    public String komentar;

    public Komentar(String username, String komentar) {
        this.username = username;
        this.komentar = komentar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    @Override
    public String toString() {
        return username + " - " + komentar;
    }
}
