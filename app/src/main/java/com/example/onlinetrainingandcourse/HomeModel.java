package com.example.onlinetrainingandcourse;

public class HomeModel {

    String picurl, coursename, offerby;
    Float rating;

    HomeModel(){

    }

public HomeModel(String picurl, String coursename, String offerby, Float rating) {
        this.picurl = picurl;
        this.coursename = coursename;
        this.offerby = offerby;
        this.rating = rating;
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
