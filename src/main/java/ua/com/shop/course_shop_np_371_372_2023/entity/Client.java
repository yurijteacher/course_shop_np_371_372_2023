package ua.com.shop.course_shop_np_371_372_2023.entity;


import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Client {

    private Long id;
    private String firstName;

    private String lastName;

    private int age;

    private int phone;

    private String email;

    private Users user;

    private List<Address> addressList;

    private List<Order> orders;

}
