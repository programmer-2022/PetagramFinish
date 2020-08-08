package com.coursera.petagramfinish;

import java.io.Serializable;

public class Pet implements Serializable {

    private int photo;
    private String name;
    private int imgWhiteBone;
    private String rate;
    private int imgYellowBone;
    private int iconStar;
    private boolean like;

    public Pet(int photo, String name, String rate) {
        this.photo = photo;
        this.name = name;
        this.imgWhiteBone = R.drawable.white_bone;
        this.rate = rate;
        this.imgYellowBone = R.drawable.yellow_bone;
        this.iconStar = R.drawable.start;
        this.like = false;
    }

    public int getPhoto() {
        return photo;
    }
    public String getName() {
        return name;
    }
    public int getImgWhiteBone() {
        return imgWhiteBone;
    }
    public String getRate() {
        return rate;
    }
    public int getImgYellowBone() {
        return imgYellowBone;
    }
    public int getIconStar() { return iconStar; }
    public void setRate(String rate) {
        this.rate = rate;
    }
    public boolean isLike() { return like; }
    public void setLike(boolean like) {
        this.like = like;
    }

    public int changeImage() {
        return (!this.like) ? R.drawable.white_bone : R.drawable.yellow_bone;
    }
}