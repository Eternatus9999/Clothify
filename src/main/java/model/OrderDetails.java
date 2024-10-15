package model;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderDetails {
    private String id;
    private String name;
    private String orid;
    private int qty;
    private double price;
    private double discount;

    public OrderDetails(String id,String name, String orid, int qty, double price){
        this.id = id;
        this.orid = orid;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }
}
