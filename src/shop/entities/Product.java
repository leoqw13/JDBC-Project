
package shop.entities;

public class Product {
    private int code;
    private String name;
    private double price;
    private int codeManufacturer;

    public Product(int code, String name, double price, int codeManufacturer) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.codeManufacturer = codeManufacturer;
    }

    public Product() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCodeManufacturer() {
        return codeManufacturer;
    }

    public void setCodeManufacturer(int codeManufacturer) {
        this.codeManufacturer = codeManufacturer;
    }

   


}
