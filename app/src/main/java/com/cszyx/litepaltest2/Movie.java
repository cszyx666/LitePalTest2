package com.cszyx.litepaltest2;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

public class Movie extends LitePalSupport {

    @Column(unique=true,defaultValue = "unknown")
    private String namw;

    @Column(ignore = true)
    private float price;

    private byte[] cover;

    private int duration;

    public String getNamw() {
        return namw;
    }

    public void setNamw(String namw) {
        this.namw = namw;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(nullable = false)
    private String director;

    private String type;
}
