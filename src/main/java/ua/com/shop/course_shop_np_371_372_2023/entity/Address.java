package ua.com.shop.course_shop_np_371_372_2023.entity;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Address {

    private Long id;

    private String country;

    private String city;

    private String building;

    private Client client;



}
