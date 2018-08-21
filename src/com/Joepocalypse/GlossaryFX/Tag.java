package com.Joepocalypse.GlossaryFX;

public class Tag {
    private final String open, close;

    public Tag(String open, String close){
        this.open = open;
        this.close = close;
    }

    public String getOpenTag() {
        return open;
    }

    public String getCloseTag() {
        return close;
    }
}
