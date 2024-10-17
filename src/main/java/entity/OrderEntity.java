package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class OrderEntity {
    @Id
    private String orid;
    private String custname;
    private String custemail;
    private String paymenttype;
    private double total;
    private double discount;
    private LocalDate date;
    private String employeeid;
}
