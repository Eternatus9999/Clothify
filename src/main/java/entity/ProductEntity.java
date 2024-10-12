package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class ProductEntity {

    @Id
    private String id;
    private String name;
    private String size;
    private String supplier;
    private int qty;
    private double price;
    private String category;
}
