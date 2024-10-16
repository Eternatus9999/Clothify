package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetails {
    private String id;
    private String orid;
    private String name;
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
