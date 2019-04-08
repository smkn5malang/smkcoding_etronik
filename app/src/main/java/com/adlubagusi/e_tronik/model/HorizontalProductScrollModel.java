package com.adlubagusi.e_tronik.model;

public class HorizontalProductScrollModel {
    private int productImg;
    private String productTitle;
    private String productDesc;
    private String productPrice;

    public HorizontalProductScrollModel(int productImg, String productTitle, String productDesc, String productPrice) {
        this.productImg = productImg;
        this.productTitle = productTitle;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
    }

    public int getProductImg() {
        return productImg;
    }

    public void setProductImg(int productImg) {
        this.productImg = productImg;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
