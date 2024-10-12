package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private String id;
    private String name;
    private String size;
    private String supplier;
    private int qty;
    private double price;
    private String category;
}
