package com.dani.missionhewan;

public class DataHewan {
    private String name, penjelasan, sumber_dari, images;

    public DataHewan(){

    }

    public DataHewan(String nama, String pengertian, String sumber, String img){
        this.name = nama;
        this.penjelasan = pengertian;
        this.sumber_dari = sumber;
        this.images = img;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPenjelasan() {
        return penjelasan;
    }

    public void setPenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }

    public String getSumber_dari() {
        return sumber_dari;
    }

    public void setSumber_dari(String sumber_dari) {
        this.sumber_dari = sumber_dari;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
