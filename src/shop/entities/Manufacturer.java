
package shop.entities;


public class Manufacturer {
    private int code;
    private String name;

    public Manufacturer(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public Manufacturer() {
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

}
