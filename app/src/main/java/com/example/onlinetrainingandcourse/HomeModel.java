package com.example.onlinetrainingandcourse;

public class HomeModel {

    String picurl, coursename, offerby, description, videourl;
    Float rating;

    HomeModel(){

    }

public HomeModel(String picurl, String coursename, String offerby, Float rating, String description, String videourl) {
        this.picurl = picurl;
        this.coursename = coursename;
        this.offerby = offerby;
        this.rating = rating;
        this.description = description;
        this.videourl = videourl;
    }

    public String getDescription() {
        return description;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public void setOfferby(String offerby) {
        this.offerby = offerby;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getPicurl() {
        return picurl;
    }

    public String getCoursename() {
        return coursename;
    }

    public String getOfferby() {
        return offerby;
    }

    public Float getRating() {
        return rating;
    }
}
