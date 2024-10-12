package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    private String id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String password;

}
