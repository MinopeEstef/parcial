package com.example.parcial_ejemplo;

public class Item {
    private String code;
    private String name;
    private int stock;
    private Double sale;
    private String size;
    private String description;

    public Item(String code, String name, int stock, Double sale, String size, String description) {
        this.code = code;
        this.name = name;
        this.stock = stock;
        this.sale = sale;
        this.size = size;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus(){
        if(this.stock > 0){
            return "Disponible";
        }else{
            return "No disponible";
        }
    }

    @Override
    public String toString() {
        return "Item{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                ", sale=" + sale +
                ", size='" + size + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
