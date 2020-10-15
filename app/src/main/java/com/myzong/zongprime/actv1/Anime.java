package com.myzong.zongprime.actv1;


public class Anime {

    private String title ;
    private String volume;
    private String duration;
    private String detail ;
    private String activation ;
    private String deactivation ;
    private String price ;
    private String photo ;

    public Anime() {
    }

    public Anime(String title, String volume,  String duration, String detail, String activation,String deactivation, String price, String photo) {
        this.title = title;
        this.volume = volume;
        this.duration = duration;
        this.detail = detail;
        this.activation = activation;
        this.deactivation = deactivation;
        this.price = price;
        this.photo = photo;
    }
    public String getTitle() {
        return title;
    }
    public String getVolume() {
        return volume;
    }
    public String getDuration() {
        return duration;
    }
    public String getDetail() {
        return detail;
    }
    public String getActivation() { return activation; }
    public String getDeactivation() {
        return deactivation;
    }
    public String getPrice() {
        return price;
    }
    public String getPhoto() {
        return photo;
    }


    public void setTitle(String title) {
        this.title = title;
    }
    public void setVolume(String volume) {
        this.volume = volume;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public void setDetail(String detail) { this.detail = detail; }
    public void setActivation(String activation) {
        this.activation = activation;
    }
    public void setDeactivation(String deactivation) {
        this.deactivation = deactivation;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }



}
