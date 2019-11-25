package com.google.sample.cloudvision;

public class Product {
    public String barcode;
    public String pname;
    public String carbohydate;
    public String protein;
    public String fat;
    public String company;
    public String pallergy;
    public String alter;

    public String getProduct(){
        return barcode+"/"+pname+"/"+carbohydate+"/"+protein+""+fat+"/"+company+"/"+pallergy;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCarbohydate() {
        return carbohydate;
    }

    public void setCarbohydate(String carbohydate) {
        this.carbohydate = carbohydate;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPallergy(){
        return pallergy;
    }

    public void setPallergy(String pallergy){
        this.pallergy = pallergy;
    }

    public String getAlter(){
        return alter;
    }

    public void setAlter(String alter){
        this.alter = alter;
    }
    public Product(String barcode, String pname, String carbohydate, String protein, String fat, String company, String pallergy){
        this.barcode = barcode;
        this.pname = pname;
        this.carbohydate = carbohydate;
        this.protein = protein;
        this.fat = fat;
        this.company = company;
        this.pallergy = pallergy;
        this.alter = "경고입니다!";
    }


}
