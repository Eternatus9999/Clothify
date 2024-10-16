package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsEntity {
    @Id
    private String id;
    @Id
    private String orid;
    private String name;
    private int qty;
    private double price;
    private double discount;
}
