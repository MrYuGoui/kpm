package com.example.kpm.controller;

public class ResKw {
    private final int status;
    private final String reply;

    public ResKw(int status, String reply) {
        this.status = status;
        this.reply = reply;
    }

    public long getStatus() {
        return status;
    }

    public String getContent() {
        return reply;
    }
}
