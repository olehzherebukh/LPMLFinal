package com.olezhko.lpmldemo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Cafe implements Serializable {

    private String name;
    private String address;
    private int pictureId;

    public Cafe(String name, String address, int pictureId) {
        this.name = name;
        this.address = address;
        this.pictureId = pictureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }
}
