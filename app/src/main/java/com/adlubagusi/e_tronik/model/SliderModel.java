package com.adlubagusi.e_tronik.model;

public class SliderModel {
    private int banner;

    private String bgColor;

    public SliderModel(int banner, String bgColor) {
        this.banner = banner;
        this.bgColor = bgColor;
    }

    public int getBanner() {
        return banner;
    }

    public void setBanner(int banner) {
        this.banner = banner;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }
}
