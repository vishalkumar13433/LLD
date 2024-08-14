package org.lld.dto;

public class Restaurant {
    Menu menu;
    Double avgRating;

    Double latitude;
    Double longitude;

    String address;

    public Restaurant(Menu menu, Double latitude, Double longitude, String address) {
        this.menu = menu;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.avgRating = 0d;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
